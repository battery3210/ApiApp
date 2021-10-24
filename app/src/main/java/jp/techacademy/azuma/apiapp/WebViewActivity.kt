package jp.techacademy.azuma.apiapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_web_view.*
import android.view.LayoutInflater
import android.view.Menu


class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView.loadUrl(intent.getStringExtra(KEY_URL).toString())
        Log.d("test","success3")
    }

    // 取得したJsonデータを解析し、Shop型オブジェクトとして生成したものを格納するリスト
    private val items = mutableListOf<Shop>()

    // 一覧画面から登録するときのコールバック（FavoriteFragmentへ通知するメソッド)
    var onClickAddFavorite: ((Shop) -> Unit)? = null
    // 一覧画面から削除するときのコールバック（ApiFragmentへ通知するメソッド)
    var onClickDeleteFavorite: ((Shop) -> Unit)? = null


    companion object{
        private const val KEY_URL = "key_url"
        fun start(activity: Activity,url:String){
            activity.startActivity(Intent(activity,WebViewActivity::class.java).putExtra(KEY_URL,url))
        }
    }

    private fun updateApiItemViewHolder(holder: ApiAdapter.ApiItemViewHolder, position: Int) {
        // 生成されたViewHolderの位置を指定し、オブジェクトを代入
        val data = items[position]
        //お気に入り状態を取得
        val isFavorite = FavoriteShop.findBy(data.id) != null
        holder.apply {
            /*
            rootView.apply {
                // 偶数番目と奇数番目で背景色を変更させる
                setBackgroundColor(ContextCompat.getColor(context,
                    if (position % 2 == 0) android.R.color.white else android.R.color.darker_gray))
            }
             */
            // nameTextViewのtextプロパティに代入されたオブジェクトのnameプロパティを代入
            //nameTextView.text = data.name
            //nameAddressView.text = data.address
            // Picassoライブラリを使い、imageViewにdata.logoImageのurlの画像を読み込ませるｓｓ
            //Picasso.get().load(data.logoImage).into(imageView)
            // 白抜きの星マークの画像を指定
            favoriteCouponImageView.apply {
                setImageResource(if (isFavorite) R.drawable.ic_star else R.drawable.ic_star_border) //Picassoというライブラリを使ってImageVIewに画像をはめ込む
                setOnClickListener{
                    if(isFavorite){
                        onClickDeleteFavorite?.invoke(data)
                    } else {
                        onClickAddFavorite?.invoke(data)
                    }
                    //notifyItemChanged(position)
                }
            }
        }
    }




}