package com.base.arch.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import kotlin.math.roundToInt

/**
 * @author jacky
 * @date 2021/11/9
 * 高斯模糊工具类
 */
object BlurUtil {


    /**
     * 模糊图片的具体方法
     *
     * @param context 上下文对象
     * @param ImageDrawable 需要模糊的资源图片
     * @param bitmapScale 图片缩放比例
     * @param radius 最大模糊度(在0.0到25.0之间)
     * @return 模糊处理后的图片
     */
    fun blur(context: Context?, ImageDrawable: Drawable?, bitmapScale: Float, radius: Float): Bitmap? {
        val bitmapDrawable = ImageDrawable as BitmapDrawable
        val image = bitmapDrawable.bitmap
        // 计算图片缩小后的长宽
        val width = (image.width * bitmapScale).roundToInt()
        val height = (image.height * bitmapScale).roundToInt()
        // 将缩小后的图片做为预渲染的图片。
        val inputBitmap = Bitmap.createScaledBitmap(image, width, height, false)
        // 创建一张渲染后的输出图片。
        val outputBitmap = Bitmap.createBitmap(inputBitmap)
        // 创建RenderScript内核对象
        val rs = RenderScript.create(context)
        // 创建一个模糊效果的RenderScript的工具对象
        val blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))
        // 由于RenderScript并没有使用VM来分配内存,所以需要使用Allocation类来创建和分配内存空间。
        // 创建Allocation对象的时候其实内存是空的,需要使用copyTo()将数据填充进去。
        val tmpIn = Allocation.createFromBitmap(rs, inputBitmap)
        val tmpOut = Allocation.createFromBitmap(rs, outputBitmap)
        // 设置渲染的模糊程度, 25f是最大模糊度
        blurScript.setRadius(radius)
        // 设置blurScript对象的输入内存
        blurScript.setInput(tmpIn)
        // 将输出数据保存到输出内存中
        blurScript.forEach(tmpOut)
        // 将数据填充到Allocation中
        tmpOut.copyTo(outputBitmap)
        return outputBitmap
    }


    /**
     * 模糊图片的具体方法
     *
     * @param context 上下文对象
     * @param image 需要模糊的资源图片Bitmap
     * @param bitmapScale 图片缩放比例
     * @param radius 最大模糊度(在0.0到25.0之间)
     * @return 模糊处理后的图片
     */
    fun blur(context: Context?, image:Bitmap, bitmapScale: Float, radius: Float): Bitmap? {

        val width = (image.width * bitmapScale).roundToInt()
        val height = (image.height * bitmapScale).roundToInt()
        val inputBitmap = Bitmap.createScaledBitmap(image, width, height, false)
        val outputBitmap = Bitmap.createBitmap(inputBitmap)
        val rs = RenderScript.create(context)
        val blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))
        val tmpIn = Allocation.createFromBitmap(rs, inputBitmap)
        val tmpOut = Allocation.createFromBitmap(rs, outputBitmap)
        blurScript.setRadius(radius)
        blurScript.setInput(tmpIn)
        // 将输出数据保存到输出内存中
        blurScript.forEach(tmpOut)
        // 将数据填充到Allocation中
        tmpOut.copyTo(outputBitmap)
        return outputBitmap
    }

}