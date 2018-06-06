package cn.sibat.pushdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 通用适配器的ViewHolder，此类可以设定任意控件的显示
 *
 * @author  沈吉荣
 */
public class CommonViewHolder {

    // 键值对进行保存，键为控件的Id，值为控件的引用;SparseArray比Map效率，不过键只能为Integer
    private final SparseArray<View> mViews;
    private View mConvertView;
    private  int mPosition;
    private MyClickListener mListener;
    private MyCheckedListener myCheckedListener;

    private CommonViewHolder(Context context, ViewGroup parent, int layoutId,
                             int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        // setTag
        mConvertView.setTag(this);

    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static CommonViewHolder get(Context context, View convertView,
                                       ViewGroup parent, int layoutId, int position) {

        if (convertView == null) {
            return new CommonViewHolder(context, parent, layoutId, position);
        }
        return (CommonViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public CommonViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    /**
     * 为TextView设置字符串,加中划线
     *
     * @param viewId
     * @param text
     * @return
     */
    public CommonViewHolder setTextWithLine(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        view.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        return this;
    }



    /**
     * 为TextView设置字符串，设置字体颜色
     *
     * @param viewId
     * @param text
     * @param colorId
     * @return
     */
    public CommonViewHolder setTextWithColor(int viewId, String text, int colorId) {
        TextView view = getView(viewId);
        view.setTextColor(colorId);
        view.setText(text);
        return this;
    }





    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public CommonViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param bm
     * @return
     */
    public CommonViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 设置view的可见性
     *
     * @param viewId
     * @param visibility
     * @return
     */
    public CommonViewHolder setViewVisibility(int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }
    /**
     * 设置view的可见性
     *
     * @param viewId
     * @param clickable
     * @return
     */
    public CommonViewHolder setClickable(int viewId, boolean clickable) {
        View view = getView(viewId);
        view.setClickable(clickable);
        return this;
    }




    /**
     * 给控件设置单击监听事件
     * @param viewId 控件ID
     * @param listener 回调接口
     * @return
     */
    public CommonViewHolder setClickListener(int viewId, MyClickListener listener){
        View view = getView(viewId);
        mListener = listener;
        view.setOnClickListener(mListener);
        return this;
    }
    /**
     * 给控件设置选择监听事件
     * @param viewId 控件ID
     * @param listener 回调接口
     * @return
     */
    public CommonViewHolder setCheckBoxListener(int viewId, MyCheckedListener listener, int itemPosition){
        CheckBox view = getView(viewId);
        view.setTag(itemPosition);
        myCheckedListener = listener;
        view.setOnCheckedChangeListener(myCheckedListener);
        return this;
    }

    /**
     * 给控件设置checkbox的状态
     * @param viewId 控件ID
     * @param state 控件状态
     * @return
     */
    public CommonViewHolder setCheckBoxCheckstate(int viewId, boolean state){
        CheckBox view = getView(viewId);
        view.setChecked(state);
        return this;
    }

    /**
     * 获取item位置
     *
     * @return item位置mPosition
     */
    public int getPosition() {
        return mPosition;
    }


    /**
     * 用于点击回调的抽象类
     */
    public static abstract class MyClickListener implements View.OnClickListener {
        /**
         * 基类的onClick方法
         */
        @Override
        public void onClick(View v) {

        }
    }
    /**
     * 用于checkbox选择回调的抽象类
     */
    public static abstract class MyCheckedListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            myOnCheckedChanged((Integer) buttonView.getTag(),buttonView,isChecked);
        }

        public abstract void myOnCheckedChanged(int position, View v, boolean isChecked);
    }

}
