package com.showoffs.tmdb.custom

import android.content.Context
import android.util.AttributeSet

import com.facebook.drawee.generic.GenericDraweeHierarchy
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by Gaurav Ravi on 7/22/2016.
 */

class ConstrainedImageView : SimpleDraweeView {
    constructor(context: Context, hierarchy: GenericDraweeHierarchy) : super(context, hierarchy) {}

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        this.setMeasuredDimension(this.measuredWidth, (1.5 * this.measuredWidth.toDouble()).toInt())
    }
}