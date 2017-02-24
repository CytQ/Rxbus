##Get it


##How to use it

**Send message to bus**

```java
 
 Bundle bundle = new Bundle();
 
 bundle.putString("info", "testInfo");
 
 RxBus.getInstance().send(new Event(EventConstants.SEND_MSG, bundle,TAG));   
      
```

**Handle message**

```java

Subscription rxbus = RxBus.getInstance().toObserverable()
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new Func1<Object, Event>() {
                        @Override
                        public Event call(Object o) {
                            return (Event) o;
                        }
                    })
                    .subscribe(new Action1<Event>() {
                        @Override
                        public void call(Event event) {
                            handleEvent(event);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.d(TAG, throwable.getMessage());
                        }
                    });
                    
private void handleEvent(Event event) {

}
```
You can change the kind of event in map function:

```java
map(new Func1(Object, "Object which you want")) {
    @Override
    public "Object which you want" call(Object o) {
    	return ("Object which you want")o;
    }
}

```

##Notice##
Developer must unsubsribe the rxbus subscription when you finish the activity or fragment pervent from the memory leak. See it in Demo.

```java
rxbus.unsubscribe();
```
