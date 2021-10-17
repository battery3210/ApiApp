package jp.techacademy.taro.kirameki.apiapp

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FavoriteAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    // お気に入り登録したShopを格納
    private val items = mutableListOf<FavoriteShop>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    // 更新用のメソッド
    fun refresh(list: List<FavoriteShop>) {
        items.apply {
            clear() // items を 空にする
            addAll(list) // itemsにlistを全て追加する
        }
        notifyDataSetChanged() // recyclerViewを再描画させる
    }

    // お気に入りが1件もない時に、「お気に入りはありません」を出すため
    override fun getItemCount(): Int {
        return if (items.isEmpty()) 1 else items.size
    }

    // onCreateViewHolderの第二引数はここで決める。条件によってViewTypeを返すようにすると、一つのRecyclerViewで様々なViewがある物が作れる
    override fun getItemViewType(position: Int): Int {
        return if (items.isEmpty()) VIEW_TYPE_EMPTY else VIEW_TYPE_ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        // Viewの種類を表現する定数、こちらはお気に入りのお店
        private const val VIEW_TYPE_ITEM = 0
        // Viewの種類を表現する定数、こちらはお気に入りが１件もないとき
        private const val VIEW_TYPE_EMPTY = 1
    }
}