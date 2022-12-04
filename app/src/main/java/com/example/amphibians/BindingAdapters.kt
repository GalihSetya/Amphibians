package com.example.amphibians

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import androidx.recyclerview.widget.RecyclerView
import com.example.amphibians.network.Amphibian
import com.example.amphibians.ui.AmphibianApiStatus
import com.example.amphibians.ui.AmphibianListAdapter
/**
 * Updates the data shown in the [RecyclerView]
 */
// mengupdate data yang ditampilkan pada RecyclerView
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Amphibian>?) {
    val adapter = recyclerView.adapter as AmphibianListAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_connection_error)
        }
    }
}

/**
 * This binding adapter displays the [AmphibianApiStatus] of the network request in an image view.
 * When the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
 */
//adaptor binding ini menampilkan [AmphibianApiStatus] permintaan jaringan dalam tampilan gambar.
//Saat permintaan dimuat, menampilkan loading_animation.
// Jika permintaan memiliki kesalahan, menampilkan gambar yang rusak untuk mencerminkan kesalahan koneksi.
// Ketika permintaan selesai, itu menyembunyikan tampilan gambar.

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: AmphibianApiStatus?) {
    when(status) {
        AmphibianApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        AmphibianApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        AmphibianApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}
