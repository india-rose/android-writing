package com.example.indiaroseapplicationdessin.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lisa on 29/04/14.
 */
public class FondDessin  extends View {
    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private int paintColor = 0xFF660000;
    private Canvas drawCanvas = new Canvas();
    private Bitmap canvasBitmap, modelBitmap;


    public FondDessin(Context context){
        super(context);
        setupDrawing();
    }

    public FondDessin(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        setupDrawing();
    }

    public FondDessin(Context context,  Bitmap model){
        super(context);
        setupDrawing();
        modelBitmap=model;

    }


    private void setupDrawing(){
        canvasPaint = new Paint(Paint.DITHER_FLAG);
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        drawPaint.setStrokeWidth(20);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
         canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
        background();
    }


    //affichage du modèle en fond du canvas
   protected void background (){
        if (modelBitmap==null){
       modelBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blanc);
        }
        modelBitmap = Bitmap.createScaledBitmap(modelBitmap, drawCanvas.getWidth(), drawCanvas.getHeight()*80/100, false);
        Drawable b = new BitmapDrawable(getResources(),modelBitmap);
        this.setBackground(b);
    }

    @Override
    protected void onDraw(Canvas drawCanvas) {
       drawCanvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        drawCanvas.drawPath(drawPath, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }



    public Canvas getDrawCanvas() {
        return drawCanvas;
    }


    public Paint getDrawPaint() {
        return drawPaint;
    }

    public void setModelBitmap(Bitmap modelBitmap) {
        this.modelBitmap = modelBitmap;
    }

    public Object getModelBitmap() {
        return modelBitmap;
    }
}
