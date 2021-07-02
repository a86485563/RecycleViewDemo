# how to build RecycleView

此篇展示`RecycleView`的使用方式，和一些簡單的功能如托、拉。

## 目錄

- [簡介](#簡介)
- [RecycleView](#recycleview)
  - [Why RecycleView?](#why-recycleview)
  - [layout](#layout)
  - [kotlin](#kotlin)
- [ItemTouchHelper](#itemtouchhelper)
- [ref](#ref)

## 簡介

根據官網:

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

## RecycleView

決定畫面的呈現。

## Why RecycleView?

能夠有效的減少資源。
原理是，將滑出畫面外的 element 儲存起來，當再次滾動到的時候直接取出來使用。

想像一個大櫃子，裡面由好幾格小抽屜組成。而我們的畫面就像是眼睛看出去的部分，當你往下看，櫃子上方的東西依然存在，只是不再畫面內而已。

## layout

- item_example.xml : 小抽屜的長相。
- main activity.xml : 整個 app 的呈現，決定大櫃子擺放的位置。

## kotlin

```kotlin
 recycleView.layoutManager = LinearLayoutManager(this)
 recycleView.adapter = mAdapter
  //this 指的是 context
```

mApapter 延伸 _RecyclerView.Adapter<MyAdapter.mViewHolder>_ 介紹幾個比較重要的梗

- mViewHolder 其實就是一個 nset class，表示該 class 只與 mApapter 有關，延伸至 _RecyclerView.ViewHolder(itemView)_。`用來處理view傳進來後，資料如何綁定，對應到決定小抽屜的擺設`

- _onCreateViewHolder_ `最主要目的就是告訴mViewHolder 是和哪個xml有關`
- _onBindViewHolder(holder: mViewHolder, position: Int)_ `注意到傳來position，意思是大櫃子裡一層層的綁定`

## ItemTouchHelper

目的就是完成，托、拉、滑動之後的邏輯設定，有以下方法完成。

- ItemTouchHelperInterface 之術 膩膩。
- simpleCallback。

兩個方法都有寫詳見分支。

`目標就是完成`

```kotlin
  val callback = ItemTouchHelperCallback(mAdapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recycleView)
```

## ref
1. https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ItemTouchHelper
2. https://ithelp.ithome.com.tw/articles/10238539
3. https://ithelp.ithome.com.tw/articles/10239304
