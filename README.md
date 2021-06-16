# how to build item slider

    ref:
    1.https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ItemTouchHelper
    2.https://ithelp.ithome.com.tw/articles/10239304

已有:

- recycle view 基礎
- 要拖曳的 item
  詳細請看上回

`進入正題`

`最重要的就是這三句，接下來就是想辦法完成他們`

```kotlin
   val callback = ItemTouchHelperCallback(mAdapter)
   val touchHelper = ItemTouchHelper(callback)
   touchHelper.attachToRecyclerView(recycleView)
```

根據 官網:

```kotlin
ItemTouchHelper(@NonNull callback: ItemTouchHelper.Callback)
```

如何完成 _ItemTouchHelper_?

> 根據官網
>
> This is a utility class to add swipe to dismiss and drag & drop support to RecyclerView.

> It works with a RecyclerView and a Callback class, which configures what type of interactions are enabled and also receives events when user performs these actions.

> Depending on which functionality you support, you should override Callback#onMove(RecyclerView, ViewHolder, ViewHolder) and / or Callback#onSwiped(ViewHolder, int).

所以有了以下思路:

1. 既然是 callback 因該要為 command patten 把動作封裝起來，官網提示要我們自己複寫 onMove()、onSwiped() 兩個 method -> 要有一個 interface _ITHelperInterface_
2. 由我們自己的 adapter "_MyAdapter_" 去實作*ITHelperInterface* 所定義的兩個 method
3. 最後 _ItemTouchHelperCallback_ extend _ItemTouchHelper.Callback_ 然後使用接受的參數(interface 裡定義的兩個 method)

最後還提供了比較便捷的方式 simpleCallback() 在分支裡面~
