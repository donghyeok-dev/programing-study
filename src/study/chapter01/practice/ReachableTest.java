package study.chapter01.practice;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReachableTest {

    // https://blog.javarouka.me/2018/11/26/Finalizer%EC%99%80-Cleaner/
    public static class Refer{
        private String className;

        public Refer() {}
        public Refer(String className) {
            this.className = className;
        }

        protected void finalize() {
            System.out.printf(">>%s Refer finalize!%n", className);
        }
    }

    public static void MyGc(String message) throws InterruptedException {
        System.out.printf("[%s]%n", message);
        System.out.println("gc start ------------->");
        System.gc();
        Thread.sleep(1000);
        System.out.println("gc end <---------------");
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * Strong reference
         * 일반적으로 new 하여 객체를 생성하고 참조하는 형태이며,
         * 참조하고 있는 변수는 JVM Stack 영역에 들어가고,
         * 변수가 참조하고 있는 인스턴스는 Heap 영역에 생성되는데
         * JVM Stack에 참조변수를 포함하고 있는 스택프레임이 제거 되거나
         * 참조변수가 null 등 다른 곳을 가르키기 전까지 Heap 영역의 인스턴스는 GC 대상이 되지 않습니다.
         */
        testStrongReference();

        /**
         * Softreference
         * 인스턴스가 메모리 회수 대상이라고 하여도 힙 영역에 여유가 있으면 GC하지 않고,
         * 부족해지면 GC합니다. 단 스택프레임에서 할당된 변수가 참조하는 인스턴스는 메서드가 종료될 때
         * 즉 JVM 스택에서 스택프레임이 pop되어 제거 될 때 GC 대상이 됩니다.
         * 하지만 JVM, GC에 따라 동작이 달라질 수 있으며 임베디드 시스템의 경우는
         * 메모리가 작기 때문에 GC될 확률이 높습니다.
         *
         */
        testSoftReference();

        /**
         * Weekreference
         * 인스턴스가 Reachable 상태일지라도 GC 대상으로 지정한다.
         * 즉 무조건 GC 대상으로 지정하고 싶은 객체를 WeekReference로 지정하면 된다.
         *
         * 주의할점 : Softreference와 Weekreference는 ReferenceQueue에 enqueue되기 때문에
         * 이전에 GC대상인데 보류된 Reference 객체가 있다면 그 인스턴스만 처리된다.
         * 예를들어 testSoftReference()에서 인스턴스가 GC되지 않고 보류 인 상태에서
         * testWeakReference()의 WeekRefernce 인스턴스가 GC대상이면 Softreference 인스턴스만
         * GC 되어 버린다.. 실제 결과도 아래처럼 Week자리에 Soft만 GC되는 것을 볼 수 있다.
         * [WeakReference는 refer(study.chapter01.practice.ReachableTest$Refer@97e1986)객체의 참조상태를 무시하고 무조건 GC 해버림]
         * gc start ------------->
         * >>testSoftReference Refer finalize!
         * gc end <---------------
         */
        testWeakReference();

        /**
         * SoftReference와 WeekReference는 GC 대상 여부를 결정하는 부분에 관여했다면,
         * PhantomReference는 파이널라이즈와 메모리 회수 사이를 관여한다.
         * 객체참조 상태가 아니면 GC 대상이 되는데 이때 testWeakReference()는 ReferenceQueue에 enqueue 되면서
         * 이전 GC 대상 하나만 실행되었는데, PhantomReference는 가장 먼저 finalize()를 실행하고 그 다음 ReferenceQueue를
         * 실행하기 때문에 PhantomReference의 finalize() 호출 후 GC 대상이었던 WeakReference의 finalize()가 실행된다.
         * 즉 둘 다 GC가 되었음.
         * [PhantomReference refer(null)객체의 참조상태가 아닐 때 GC 함.]
         * gc start ------------->
         * >>testPhantomReference Refer finalize!
         * >>testWeakReference Refer finalize!
         * gc end <---------------
         */
        testPhantomReference();

        MyGc("Main");
    }

    public static void testStrongReference() throws InterruptedException {
        Refer refer = new Refer("testStrongReference");

        refer = null; // gc 대상

        MyGc(String.format("StrongReference는 refer(%s)객체의 참조상태가 아닐 때 GC 됨.", refer));
    }

    public static void testSoftReference() throws InterruptedException {
        Refer refer = new Refer("testSoftReference");

        SoftReference<Refer> softReference = new SoftReference<>(refer);

        refer = null; // GC 대상

        MyGc(String.format("SoftReference refer(%s)객체가 참조상태가 아니라도 상황에 따라 GC 하지 않음.", refer));

//        refer = softReference.get();
    }

    public static void testWeakReference() throws InterruptedException {
        Refer refer = new Refer("testWeakReference");

        WeakReference<Refer> softReference = new WeakReference<>(refer);

        MyGc(String.format("WeakReference는 refer(%s)객체의 참조상태를 무시하고 무조건 GC 해버림", refer));

//        refer = softReference.get();
    }

    public static void testPhantomReference() throws InterruptedException {
        Refer refer = new Refer("testPhantomReference");
        ReferenceQueue dead = new ReferenceQueue();

        PhantomReference<Refer> phantom = new PhantomReference(refer, dead);

        refer = null; // GC 대상

        MyGc(String.format("PhantomReference refer(%s)객체의 참조상태가 아닐 때 GC 함.", refer));
    }


}
