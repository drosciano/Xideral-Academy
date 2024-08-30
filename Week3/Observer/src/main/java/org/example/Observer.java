public abstract class Observer {
    Observer(Subject sub) {
        sub.attach()
    }
}
