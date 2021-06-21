# how to build RecycleView

    ref:
    1.https://ithelp.ithome.com.tw/articles/10238539
    2.https://developer.android.com/guide/topics/ui/layout/recyclerview

> 根據官網:
> 关键类
> 将多个不同的类搭配使用，可构建动态列表。
>
> RecyclerView 是包含与您的数据对应的视图的 ViewGroup。它本身就是视图，因此，将 RecyclerView 添加到布局中的方式与添加任何其他界面元素相同。

> 列表中的每个独立元素都由一个 ViewHolder 对象进行定义。创建 ViewHolder 时，它并没有任何关联的数据。创建 ViewHolder 后，RecyclerView 会将其绑定到其数据。您可以通过扩展 RecyclerView.ViewHolder 来定义 ViewHolder。

> RecyclerView 会请求这些视图，并通过在 Adapter 中调用方法，将视图绑定到其数据。您可以通过扩展 RecyclerView.Adapter 来定义 Adapter。

> 布局管理器负责排列列表中的各个元素。您可以使用 RecyclerView 库提供的某个布局管理器，也可以定义自己的布局管理器。布局管理器均基于库的 LayoutManager 抽象类。

`轉成程式碼就變成重要的兩句話`

```kotlin
  recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = mAdapter
```

> adapter 是甚麼?
>
> 想像一個大櫃子，裡面由好幾格小抽屜組成。 adapter 就是幫我們處理好邏輯要怎麼放入，放入甚麼東西進入抽屜的東西。

`正題開始`

> 1.  layout :
>     > - item_example.xml : 小抽屜的長相
>     > - main activity.xml : 整個 app 的呈現，大櫃子怎麼擺放
>
> 2.kotlin :
>
> - recycleView.layoutManager = LinearLayoutManager(this)
> - recycleView.adapter = mAdapter
>
> > mApapter 延伸 _RecyclerView.Adapter<MyAdapter.mViewHolder>_ 介紹幾個比較重要的梗
> >
> > - mViewHolder 其實就是一個 nset class，該 class 只與 mApapter 有關，延伸至 _RecyclerView.ViewHolder(itemView)_。`用來處理view傳進來後，資料如何綁定，對應到決定小抽屜的擺設`

> > - _onCreateViewHolder_ `最主要目的就是告訴mViewHolder 是和哪個xml有關`
> > - _onBindViewHolder(holder: mViewHolder, position: Int)_ `注意到傳來position，意思是大櫃子裡一層層的綁定`
