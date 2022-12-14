package az.ekvileptika.utils


import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition

fun View.toBitmap(): Bitmap {
    val returnedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(returnedBitmap)
    val bgDrawable = background
    if (bgDrawable != null)
        bgDrawable.draw(canvas)
    else
        canvas.drawColor(Color.WHITE)
    draw(canvas)
    return returnedBitmap
}

fun ImageView.load(url: String) {
    Glide.with(this)
        .load(url.trim())
        .into(this)
}

fun ImageView.loadFitCenter(url: String) {
    Glide.with(this)
        .load(url.trim())
        .apply(RequestOptions.fitCenterTransform())
        .into(this)
}

fun ImageView.loadFitCenter(uri: Uri) {
    Glide.with(this)
        .load(uri)
        .apply(RequestOptions.fitCenterTransform())
        .into(this)
}

fun ImageView.loadFitCenter(url: String, @DrawableRes placeholderResourceId: Int) {
    Glide.with(this)
        .load(url.trim())
        .apply(RequestOptions.fitCenterTransform().placeholder(placeholderResourceId))
        .into(this)
}

fun ImageView.loadFitCenter(url: String, drawable: Drawable?) {
    Glide.with(this)
        .load(url.trim())
        .apply(RequestOptions.fitCenterTransform().placeholder(drawable))
        .into(this)
}

fun ImageView.loadFitCenter(uri: Uri, @DrawableRes placeholderResourceId: Int) {
    Glide.with(this)
        .load(uri)
        .apply(RequestOptions.fitCenterTransform().placeholder(placeholderResourceId))
        .into(this)
}

fun ImageView.loadFitCenter(uri: Uri, drawable: Drawable?) {
    Glide.with(this)
        .load(uri)
        .apply(RequestOptions.fitCenterTransform().placeholder(drawable))
        .into(this)
}

fun ImageView.loadWithCircleCrop(url: String) {
    Glide.with(this)
        .load(url.trim())
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

fun ImageView.loadWithCircleCrop(uri: Uri) {
    Glide.with(this)
        .load(uri)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

fun ImageView.setBitmapWithCircleCrop(bitmap: Bitmap) {
    Glide.with(this)
        .load(bitmap)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

fun ImageView.loadFitCenterWithCircleCrop(url: String) {
    Glide.with(this)
        .load(url.trim())
        .apply(RequestOptions().fitCenter().circleCrop())
        .into(this)
}

fun ImageView.loadFitCenterWithCircleCrop(uri: Uri) {
    Glide.with(this)
        .load(uri)
        .apply(RequestOptions().fitCenter().circleCrop())
        .into(this)
}

fun ImageView.setBitmapFitCenterWithCircleCrop(bitmap: Bitmap) {
    Glide.with(this)
        .load(bitmap)
        .apply(RequestOptions().fitCenter().circleCrop())
        .into(this)
}

class SimpleTargetDrawable(width: Int, height: Int, val listener: (Drawable) -> Unit) : SimpleTarget<Drawable>(width, height) {
    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
        listener(resource)
    }
}

object GlideLogger : RequestListener<Drawable> {
    val TAG = "GlideUtils"
    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable>?,
        isFirstResource: Boolean
    ): Boolean {
        Log.d(TAG, "onLoadFailed: ${"onException(%$e, $model, $target, $isFirstResource)"}")
        return false
    }

    override fun onResourceReady(
        resource: Drawable?,
        model: Any?,
        target: Target<Drawable>?,
        dataSource: DataSource?,
        isFirstResource: Boolean
    ): Boolean {
        Log.d(
            TAG,
            "onResourceReady: ${"onResourceReady($resource, $model, $target, $dataSource, $isFirstResource)"}"
        )
        return false
    }

}