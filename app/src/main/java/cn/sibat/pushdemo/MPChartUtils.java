package cn.sibat.pushdemo;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class MPChartUtils {
    /**
     * 不显示无数据的提示
     *
     * @param mChart
     */
    public static void NotShowNoDataText(Chart mChart) {
        mChart.clear();
        mChart.notifyDataSetChanged();
        mChart.setNoDataText("你还没有记录数据");
        mChart.setNoDataTextColor(Color.WHITE);
        mChart.invalidate();
    }
    /**
     *  配置LineChart 基础设置
     * @param mLineChart 图表
     * @param mLabels x 轴标签
     * @param isShowLegend 是否显示图例
     */
    public static void configLineChart(LineChart mLineChart, List<String> mLabels, boolean isShowLegend, int yAxisColor, Legend.LegendForm shape, float legendTextSize, Legend.LegendHorizontalAlignment lha, Legend.LegendVerticalAlignment lva, Legend.LegendOrientation lo, float xAxisTextSize, float leftAxisTextSize, YAxis.YAxisLabelPosition yalp) {
        //lineChart_trafficData.setOnChartValueSelectedListener(this);
        // no description text
        mLineChart.getDescription().setEnabled(false);
        // enable touch gestures
        mLineChart.setTouchEnabled(true);
        mLineChart.setDragDecelerationFrictionCoef(0.9f);
        // enable scaling and dragging
        mLineChart.setDragEnabled(false);
        mLineChart.setScaleEnabled(false);
        mLineChart.setDrawGridBackground(false);
        mLineChart.setHighlightPerDragEnabled(true);
        // if disabled, scaling can be done on x- and y-axis separately
        mLineChart.setPinchZoom(true);
        mLineChart.setExtraBottomOffset(10);//距视图窗口底部的偏移，类似与paddingbottom
        // set an alternative background color
        //lineChart_trafficData.setBackgroundColor(Color.LTGRAY);
        // add data
        //setTrafficData(12, 30);
        mLineChart.animateX(2000);
        // get the legend (only possible after setting data)
        Legend legend = mLineChart.getLegend();
        // 是否显示图例
        if (isShowLegend) {
            legend.setEnabled(true);
            legend.setTextColor(Color.BLACK);
            legend.setForm(shape);//Legend.LegendForm.CIRCLE,Legend.LegendForm.SQUARE
            legend.setHorizontalAlignment(lha);//Legend.LegendHorizontalAlignment.CENTER,Legend.LegendHorizontalAlignment.CENTER
            legend.setVerticalAlignment(lva);//Legend.LegendVerticalAlignment.BOTTOM,Legend.LegendVerticalAlignment.TOP
            legend.setOrientation(lo);//Legend.LegendOrientation.HORIZONTAL,Legend.LegendOrientation.HORIZONTAL
            //图例的大小
            //legend.setFormSize(7f);
            // 图例描述文字大小
            legend.setTextSize(legendTextSize);//11f,16f
            //legend.setXEntrySpace(20f);
        } else {
            legend.setEnabled(false);
        }
        XAxis xAxis = mLineChart.getXAxis();
        //xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(xAxisTextSize);//11f,14f
        xAxis.setTextColor(Color.BLACK);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(11);
        final List<String> labels = mLabels;
        // 显示x轴标签
        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int index = (int) value;
                if (index < 0 || index > labels.size()) {
                    return "";
                }
                return labels.get(index-1);
            }

        };
        // 引用标签
        xAxis.setValueFormatter(formatter);
        YAxis leftAxis = mLineChart.getAxisLeft();
        //leftAxis.setTypeface(mTfLight);
        leftAxis.setAxisMinimum(0f);//设置Y轴最小值
        leftAxis.setTextSize(leftAxisTextSize);//11f,14f
        leftAxis.setTextColor(yAxisColor);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setPosition(yalp);//YAxis.YAxisLabelPosition.INSIDE_CHART,YAxis.YAxisLabelPosition.OUTSIDE_CHART
        YAxis axisRight = mLineChart.getAxisRight();
        //是否启用右边Y轴
        axisRight.setEnabled(false);
    }

    /**
     * 初始化双数据
     * @param mLineChart
     * @param yVals1
     * @param yVals2
     */
    public static void initDoubleLineData(LineChart mLineChart, ArrayList<Entry> yVals1,ArrayList<Entry> yVals2,String setName1,String setName2,int lineColor1,int lineColor2) {
            LineDataSet set1, set2;
            // create a dataset and give it a type
            set1 = new LineDataSet(yVals1, setName1);
            //set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            set1.setColor(lineColor1);
            set1.setCircleColor(Color.WHITE);
            set1.setLineWidth(2f);
            set1.setCircleRadius(3f);
            set1.setFillAlpha(65);
            set1.setFillColor(lineColor1);
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setDrawCircleHole(false);
            set1.setDrawFilled(true);
            //set1.setFillFormatter(new MyFillFormatter(0f));
            //set1.setDrawHorizontalHighlightIndicator(false);
            //set1.setVisible(false);
            //set1.setCircleHoleColor(Color.WHITE);
            // create a dataset and give it a type
            set2 = new LineDataSet(yVals2, setName2);
            //set2.setAxisDependency(YAxis.AxisDependency.RIGHT);
            set2.setColor(lineColor2);
            set2.setCircleColor(Color.WHITE);
            set2.setLineWidth(2f);
            set2.setCircleRadius(3f);
            set2.setFillAlpha(65);
            set2.setFillColor(lineColor2);
            set2.setDrawCircleHole(false);
            set2.setHighLightColor(Color.rgb(244, 117, 117));
            set2.setDrawFilled(true);
            //set2.setFillFormatter(new MyFillFormatter(900f));
            // create a data object with the datasets
            LineData data = new LineData(set1, set2);
            data.setValueTextColor(Color.WHITE);
            data.setValueTextSize(9f);
            data.setDrawValues(false);
            // set data
            mLineChart.setData(data);
            mLineChart.invalidate();
    }


    /**
     * 初始化单数据
     * @param mLineChart
     * @param yVals
     */
    public static void initSingleLineData(LineChart mLineChart, ArrayList<Entry> yVals,String setName,int lineColor,int fillColor) {
            LineDataSet set1;
            // create a dataset and give it a type
            set1 = new LineDataSet(yVals, setName);
            //set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            set1.setColor(lineColor);
            set1.setCircleColor(Color.WHITE);
            set1.setLineWidth(2f);
            set1.setCircleRadius(3f);
            set1.setFillAlpha(70);
            set1.setFillColor(fillColor);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            //set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setDrawCircleHole(true);
            set1.setDrawFilled(true);
            LineData data = new LineData(set1);
            data.setValueTextColor(fillColor);
            data.setValueTextSize(14f);
            data.setDrawValues(true);
            // set data
            mLineChart.setData(data);
            mLineChart.invalidate();
    }

    /**
     * 获取LineDataSet
     *
     * @param entries
     * @param label
     * @param textColor
     * @param lineColor
     * @return
     */
    public static LineDataSet getLineData(List<Entry> entries, String label, @ColorInt int textColor, @ColorInt int lineColor, boolean isFill) {
        LineDataSet dataSet = new LineDataSet(entries, label);
        // 设置曲线的颜色
        dataSet.setColor(lineColor);
        //数值文字颜色
        dataSet.setValueTextColor(textColor);
        // 模式为贝塞尔曲线
        dataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        // 是否绘制数据值
        dataSet.setDrawValues(false);
        // 是否绘制圆点
        dataSet.setDrawCircles(true);
        dataSet.setDrawCircleHole(false);
        // 这里有一个坑，当我们想隐藏掉高亮线的时候，MarkerView 跟着不见了
        // 因此只有将它设置成透明色
        dataSet.setHighlightEnabled(true);// 隐藏点击时候的高亮线
        //设置高亮线为透明色
        dataSet.setHighLightColor(Color.TRANSPARENT);

        if (isFill) {
            //是否设置填充曲线到x轴之间的区域
            dataSet.setDrawFilled(true);
            // 填充颜色
            dataSet.setFillColor(lineColor);
        }
        //设置圆点的颜色
        dataSet.setCircleColor(lineColor);
        // 设置圆点半径
        dataSet.setCircleRadius(3.5f);
        // 设置线的宽度
        dataSet.setLineWidth(1f);
        return dataSet;
    }

    /**
     * 获取barDataSet
     * @param entries
     * @param label
     * @param textColor
     * @param lineColor
     * @return
     */
    public static BarDataSet getBarDataSet(List<BarEntry> entries, String label, @ColorInt int textColor, @ColorInt int lineColor) {
        BarDataSet dataSet = new BarDataSet(entries, label);
        dataSet.setBarBorderWidth(5);
        dataSet.setBarShadowColor(lineColor);
        dataSet.setValueTextColor(textColor);
        dataSet.setDrawValues(false);
        return dataSet;
    }

    /**
     * 配置柱状图基础设置
     * @param barChart
     * @param xLabels
     */
    public static void configBarChart(HorizontalBarChart barChart, final List<String> xLabels, boolean legendEnabled, boolean isCenterAxisLabels) {
        barChart.getDescription().setEnabled(false);//设置描述
        barChart.setPinchZoom(false);//设置按比例放缩柱状图
        barChart.setScaleEnabled(false);
        barChart.setDragEnabled(true);
        barChart.setNoDataText(""); // 没有数据时的提示文案
        //x坐标轴设置
        // IAxisValueFormatter xAxisFormatter = new StringAxisValueFormatter(xAxisValue);//设置自定义的x轴值格式化器
        XAxis xAxis = barChart.getXAxis();//获取x轴
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴标签显示位置
        xAxis.setDrawGridLines(false);//不绘制格网线
        xAxis.setGranularity(1f);//设置最小间隔，防止当放大时，出现重复标签。
        xAxis.setCenterAxisLabels(isCenterAxisLabels);
        // 显示x轴标签
        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xLabels.get(Math.min(Math.max((int) value, 0), xLabels.size() - 1));
            }

        };
        xAxis.setValueFormatter(formatter);
        xAxis.setTextSize(14f);//设置标签字体大小
        xAxis.setTextColor(barChart.getResources().getColor(R.color.color_dark));
        xAxis.setAxisLineColor(Color.parseColor("#4cffffff"));
        xAxis.setLabelCount(xLabels.size());//设置标签显示的个数

        //y轴设置
        YAxis leftAxis = barChart.getAxisLeft();//获取左侧y轴
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);//设置y轴标签显示在外侧
        leftAxis.setAxisMinimum(0f);//设置Y轴最小值
        leftAxis.setDrawGridLines(true);
        leftAxis.setDrawLabels(true);//禁止绘制y轴标签
        leftAxis.setDrawAxisLine(false);//禁止绘制y轴
        leftAxis.setAxisLineColor(Color.parseColor("#4cffffff"));
        leftAxis.setTextColor(barChart.getResources().getColor(R.color.color_dark));
        leftAxis.setTextSize(14f);

        barChart.getAxisRight().setEnabled(false);//禁用右侧y轴
        barChart.getLegend().setEnabled(legendEnabled);
        //图例设置
        Legend legend = barChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);//图例水平居中
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);//图例在图表上方
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);//图例的方向为水平
        legend.setDrawInside(true);//绘制在chart的外侧
        //l.setTypeface(mTfLight);
        legend.setTextColor(Color.BLACK);
        //legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);//图例中的文字方向
        legend.setForm(Legend.LegendForm.CIRCLE);//图例窗体的形状
        legend.setFormSize(10f);//图例窗体的大小
        legend.setTextSize(16f);//图例文字的大小
        //legend.setYOffset(-2f);
        barChart.setExtraBottomOffset(10);//距视图窗口底部的偏移，类似与paddingbottom
        barChart.setExtraTopOffset(30);//距视图窗口顶部的偏移，类似与paddingtop
        barChart.setFitBars(true);//使两侧的柱图完全显示
        barChart.animateX(2000);//数据显示动画，从左往右依次显示
    }

    /**
     * 初始化柱状图图表数据
     * @param chart
     * @param entries
     * @param title
     * @param barColor
     */
    public static void initBarChart(HorizontalBarChart chart, List<BarEntry> entries, String title, @ColorInt int barColor) {
        BarDataSet set1 = new BarDataSet(entries, title);
        set1.setValueTextColor(Color.BLACK);
        set1.setColor(barColor);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        data.setValueTextSize(12f);
        // 设置bar的宽度，但是点很多少的时候好像没作用，会拉得很宽
        data.setBarWidth(0.8f);
        // 设置value值 颜色
        data.setValueTextColor(Color.BLACK);
        //设置y轴显示的标签
       /* data.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return ((int) (value * 100));
            }
        });*/
        chart.setData(data);
        chart.invalidate();
    }

    /**
     * 初始化分组柱状图图表数据
     * @param chart
     * @param entries1
     * @param entries2
     * @param title1
     * @param title2
     * @param barColor1
     * @param barColor2
     */
    public static void initGroupBarChart(BarChart chart, List<BarEntry> entries1, List<BarEntry> entries2,String title1,String title2, @ColorInt int barColor1,@ColorInt int barColor2,int groupCount) {
        float groupSpace = 0.48f;
        float barSpace = 0.06f; // x2 DataSet
        float barWidth = 0.2f; // x2 DataSet
        // (0.2 + 0.06) * 2 + 0.48 = 1.00 -> interval per "group"

        BarDataSet set1 = new BarDataSet(entries1, title1);
        BarDataSet set2 = new BarDataSet(entries2, title2);
        set1.setValueTextColor(Color.BLACK);
        set1.setColor(barColor1);
        set2.setValueTextColor(Color.BLACK);
        set2.setColor(barColor2);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);
        BarData data = new BarData(dataSets);
        data.setValueTextSize(12f);
        // 设置bar的宽度，但是点很多少的时候好像没作用，会拉得很宽
        data.setBarWidth(barWidth);
        // 设置value值 颜色
        data.setValueTextColor(Color.BLACK);
        //设置y轴显示的标签
       /* data.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return ((int) (value * 100));
            }
        });*/
        chart.setData(data);
        // restrict the x-axis range
        chart.getXAxis().setAxisMinimum(0);
        // barData.getGroupWith(...) is a helper that calculates the width each group needs based on the provided parameters
        chart.getXAxis().setAxisMaximum(0 + chart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        chart.groupBars(0,groupSpace,barSpace);
        chart.invalidate();
    }

    /**
     * 初始化圆环基础设置
     * @param pieChart
     * @param legendEnabled
     */
    public static void configPieChart(PieChart pieChart, boolean legendEnabled){
        pieChart.getDescription().setEnabled(false);
        pieChart.setHoleRadius(70f);//设置内圆环半径
        pieChart.setCenterTextSize(6f);//设置中间文字中大小
        pieChart.setDrawEntryLabels(false);
        Legend legend = pieChart.getLegend();//获取图例
        legend.setEnabled(legendEnabled);//图例显示
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setFormSize(10f);//图例窗体的大小
        legend.setTextSize(16f);//图例文字的大小
        pieChart.setHighlightPerTapEnabled(true);//点击不响应
        pieChart.animateXY(2000, 2000);//设置动画效果
    }

    /**
     * 设置中间文字
     * @param pieChart
     * @param sum
     * @param color1
     * @param color2
     * @param color3
     */
    public static void setSpannableString(PieChart pieChart, String sum,@ColorInt int color1,@ColorInt int color2,@ColorInt int color3,String s1,String s2){
        pieChart.setCenterText(generateCenterText(sum,color1,color2,color3,s1,s2));
        pieChart.invalidate();
    }

    /**
     * 中间文字绘制
     * @param sum 总数
     * @return
     */
    public static SpannableString generateCenterText(String sum, @ColorInt int color1, @ColorInt int color2, @ColorInt int color3,String s1,String s2) {
        String total = sum;
        //String percent = "\n 占比(%)";
        String percent = "\n "+s1;
        //SpannableString s = new SpannableString(total + percent+"\n 道路养护");
        SpannableString s = new SpannableString(total + percent+"\n "+s2);
        s.setSpan(new RelativeSizeSpan(4f), 0, total.length(), 0);
        s.setSpan(new ForegroundColorSpan(color1), 0, total.length(), 0);
        s.setSpan(new ForegroundColorSpan(color2), total.length(), total.length()+percent.length(), 0);
        s.setSpan(new RelativeSizeSpan(2f), total.length(), total.length()+percent.length(), 0);
        s.setSpan(new ForegroundColorSpan(color3), total.length()+percent.length(), s.length(), 0);
        s.setSpan(new RelativeSizeSpan(2.5f), total.length()+percent.length(), s.length(), 0);
        return s;
    }

    /**
     * @param pieChart
     * @param yVals
     * @param colors
     */
    public static void initPieChartData(PieChart pieChart,ArrayList<PieEntry> yVals,ArrayList<Integer> colors){
        PieDataSet pieDataSet = new PieDataSet(yVals, "");
        pieDataSet.setColors(colors);//颜色设置
        //pieDataSet.setSliceSpace(1f);
        pieDataSet.setDrawValues(false);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
