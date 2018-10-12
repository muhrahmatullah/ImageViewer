package com.rahmat.app.imgevwer.features.image

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.entity.Image
import com.rahmat.app.imgevwer.features.detailimage.DetailActivity
import kotlinx.android.synthetic.main.item_image.view.*
import org.jetbrains.anko.startActivity

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class ImageAdapter(val listImage: List<Image>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_image, p0, false))
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    override fun onBindViewHolder(p0: ImageViewHolder, p1: Int) {
        p0.bind(listImage[p1])
    }


    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(image: Image){
            itemView.tvCat.text = image.name
            Glide.with(itemView.context)
                    .load(image.url)
                    .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                    .apply(RequestOptions().override( 400, 200))
                    .into(itemView.imgContainer)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>()
            }
        }
    }
}