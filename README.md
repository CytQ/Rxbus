##Get it

**Gradle**

```java
// Add it in your root build.gradle at the end of repositories:

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

// Add the dependency
dependencies {
	        compile 'com.github.CytQ:Rxbus:1.0'
	}

```

**Maven**

```
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

<dependency>
	    <groupId>com.github.CytQ</groupId>
	    <artifactId>Rxbus</artifactId>
	    <version>1.0</version>
	</dependency>
```

##How to use

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
