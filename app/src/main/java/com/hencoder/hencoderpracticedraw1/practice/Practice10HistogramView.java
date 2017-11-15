package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class Practice10HistogramView extends View {
    private String name = "直方图";
    private ArrayList<Data> ll;
    private float startX;
    private float space;
    private float width;
    private float max;
    private int[] colors;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        colors=new int[7];
        colors[0]=Color.RED;
        colors[0]=Color.GREEN;
        colors[0]=Color.YELLOW;
        colors[0]=Color.BLUE;
        colors[0]=Color.BLACK;
        colors[0]=Color.GRAY;
        colors[0]=Color.RED;
        ll = new ArrayList<>();
        Data data = new Data("Froyo", 10.0f);
        ll.add(data);
        data = new Data("ICS", 18.0f);
        ll.add(data);
        data = new Data("JB", 22.0f);
        ll.add(data);
        data = new Data("KK", 27.0f);
        ll.add(data);
        data = new Data("L", 40.0f);
        ll.add(data);
        data = new Data("M", 60.0f);
        ll.add(data);
        data = new Data("N", 33.5f);
        ll.add(data);
        max = Float.MIN_VALUE;
        for (Data d : ll) {
            max = Math.max(max, d.getHeight());
        }
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(70);
        canvas.drawText(name, (canvas.getWidth() - p.measureText(name)) / 2, canvas.getHeight() * 0.9f, p);
        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.75f);//移动坐标系原点
        width = (canvas.getWidth() * 0.8f - 100) / ll.size() * 0.8f;
        space = (canvas.getWidth() * 0.8f - 100) / ll.size() - width;
        p.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, canvas.getWidth() * 0.8f, 0, p);//画横线
        canvas.drawLine(0, 0, 0, -canvas.getHeight() * 0.6f, p);
        startX = 0f;
        p.setTextSize(40);
        p.setColor(Color.GREEN);
        p.setStyle(Paint.Style.FILL);
        int c=0;
        for (Data d : ll) {
            p.setColor(Color.GREEN);
          canvas.drawRect(startX+space,-(d.getHeight()/max*canvas.getHeight()*0.6f),startX+space+width,0,p);
          p.setColor(Color.WHITE);
          canvas.drawText(d.getName(),startX+space+(width-p.measureText(d.getName()))/2,40,p);
          startX+=width+space;
        }
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }

    class Data {
        String name;
        float height;

        public Data(String name, float height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public float getHeight() {
            return height;
        }
    }
}
