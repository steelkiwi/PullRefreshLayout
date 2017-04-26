# PullRefreshLayout

Simple container for refresh list after pull event

# View

![](https://github.com/steelkiwi/PullRefreshLayout/blob/master/assets/pull-refresh-layout-animation.gif)

# Download

Download via Gradle:

```gradle
compile 'com.steelkiwi:pull-refresh-layout:1.0.0'
```

# Usage:

Add RefreshContainer to your xml layout with RecyclerView inside

```xml
<steelkiwi.com.library.view.RefreshContainer
    android:id="@+id/refreshContainer"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:overScrollMode="never"/>
</steelkiwi.com.library.view.RefreshContainer>
```

Find our RefreshContainer view group

```java
RefreshContainer refreshContainer = (RefreshContainer) findViewById(R.id.refreshContainer);
```

Also need implement refresh callback to start update adapter after pull

```java
refreshContainer.setListener(new RefreshContainer.OnRefreshListener() {
    @Override
    public void onRefresh() {
        // call your adapter update method
        refreshContainer.finishRefreshing(); // call to finish refreshing
    }
});
```

And don`t forget to call this method.

```java
refreshContainer.finishRefreshing(); // finish refreshing animation
```

# License

```
Copyright © 2017 SteelKiwi, http://steelkiwi.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```