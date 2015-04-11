package com.homg.horizontalfliplist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Homgwu
 */
public class MainViewPagerAdapter extends PagerAdapter implements OnClickListener {
    private List<ItemEntity> singerList = new ArrayList<ItemEntity>();
    private Context mContext;
    private int pagerCount = 0;
    /**
     * 用来缓存被viewpager destroy掉的view，以便重复使用
     */
    private List<View> cacheViews = new ArrayList<View>();
    private LayoutInflater mInflater;
    // private static final int TAG_VIEWHOLDER = 1;
    // private static final int TAG_ITEMDATA = 2;
    /**
     * 一页内的item个数
     */
    private double itemInCount = 10.0;

    public MainViewPagerAdapter(List<ItemEntity> itemList, Context mContext) {
        super();
        this.singerList = itemList;
        this.mContext = mContext;
        pagerCount = (int) Math.ceil(itemList.size() / itemInCount);
        mInflater = LayoutInflater.from(this.mContext);
    }

    public void updateData(List<ItemEntity> singerList) {
        this.singerList = singerList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return pagerCount;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        ((ViewPager) container).removeView(view);
        //隐藏页面内的item
        clearViewContent((ViewHolder) view.getTag());
        //添加到缓存
        cacheViews.add(view);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        ViewHolder viewHolder = null;
        //没有缓存的view时新建一个用来显示
        if (cacheViews.isEmpty()) {
            view = mInflater.inflate(R.layout.viewpager_item,
                    container, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            //有缓存的view时取出使用
            view = cacheViews.remove(0);
            viewHolder = (ViewHolder) view.getTag();
        }
        //设置页面内的各item
        initItemData(viewHolder, view, position);
        container.addView(view);
        return view;
    }

    private void initItemData(ViewHolder viewHolder, View view, int position) {
        int totalInItemCount = singerList.size();
        //每页显示10个item
        for (int i = 0; i < 10; i++) {
            //计算当前页要显示的item在arraylist中的position。
            int inItemPosition = position * 10 + i;
            //如果最后一页显示不满时跳出循环，后面的item不再显示
            if (inItemPosition >= totalInItemCount) {
                break;
            }
            ItemEntity itemEntity = singerList.get(inItemPosition);
            switch (i) {
                case 0:
                    viewHolder.bgIV1
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV1.setText(itemEntity.name);
                    viewHolder.itemRL1.setVisibility(View.VISIBLE);
                    viewHolder.itemRL1.setTag(itemEntity);
                    viewHolder.itemRL1.setOnClickListener(this);
                    break;
                case 1:
                    viewHolder.bgIV2
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV2.setText(itemEntity.name);
                    viewHolder.itemRL2.setVisibility(View.VISIBLE);
                    viewHolder.itemRL2.setTag(itemEntity);
                    viewHolder.itemRL2.setOnClickListener(this);
                    break;
                case 2:
                    viewHolder.bgIV3
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV3.setText(itemEntity.name);
                    viewHolder.itemRL3.setVisibility(View.VISIBLE);
                    viewHolder.itemRL3.setTag(itemEntity);
                    viewHolder.itemRL3.setOnClickListener(this);
                    break;
                case 3:
                    viewHolder.bgIV4
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV4.setText(itemEntity.name);
                    viewHolder.itemRL4.setVisibility(View.VISIBLE);
                    viewHolder.itemRL4.setTag(itemEntity);
                    viewHolder.itemRL4.setOnClickListener(this);
                    break;
                case 4:
                    viewHolder.bgIV5
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV5.setText(itemEntity.name);
                    viewHolder.itemRL5.setVisibility(View.VISIBLE);
                    viewHolder.itemRL5.setTag(itemEntity);
                    viewHolder.itemRL5.setOnClickListener(this);
                    break;
                case 5:
                    viewHolder.bgIV6
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV6.setText(itemEntity.name);
                    viewHolder.itemRL6.setVisibility(View.VISIBLE);
                    viewHolder.itemRL6.setTag(itemEntity);
                    viewHolder.itemRL6.setOnClickListener(this);
                    break;
                case 6:
                    viewHolder.bgIV7
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV7.setText(itemEntity.name);
                    viewHolder.itemRL7.setVisibility(View.VISIBLE);
                    viewHolder.itemRL7.setTag(itemEntity);
                    viewHolder.itemRL7.setOnClickListener(this);
                    break;
                case 7:
                    viewHolder.bgIV8
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV8.setText(itemEntity.name);
                    viewHolder.itemRL8.setVisibility(View.VISIBLE);
                    viewHolder.itemRL8.setTag(itemEntity);
                    viewHolder.itemRL8.setOnClickListener(this);
                    break;
                case 8:
                    viewHolder.bgIV9
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV9.setText(itemEntity.name);
                    viewHolder.itemRL9.setVisibility(View.VISIBLE);
                    viewHolder.itemRL9.setTag(itemEntity);
                    viewHolder.itemRL9.setOnClickListener(this);
                    break;
                case 9:
                    viewHolder.bgIV10
                            .setBackgroundResource(R.mipmap.item_bg);
                    viewHolder.titleTV10.setText(itemEntity.name);
                    viewHolder.itemRL10.setVisibility(View.VISIBLE);
                    viewHolder.itemRL10.setTag(itemEntity);
                    viewHolder.itemRL10.setOnClickListener(this);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 隐藏各item
     * @param viewHolder
     */
    private void clearViewContent(ViewHolder viewHolder) {
        viewHolder.itemRL1.setVisibility(View.GONE);
        viewHolder.itemRL2.setVisibility(View.GONE);
        viewHolder.itemRL3.setVisibility(View.GONE);
        viewHolder.itemRL4.setVisibility(View.GONE);
        viewHolder.itemRL5.setVisibility(View.GONE);
        viewHolder.itemRL6.setVisibility(View.GONE);
        viewHolder.itemRL7.setVisibility(View.GONE);
        viewHolder.itemRL8.setVisibility(View.GONE);
        viewHolder.itemRL9.setVisibility(View.GONE);
        viewHolder.itemRL10.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View arg0) {
        //点击到对应item
        ItemEntity itemEntity = (ItemEntity) arg0.getTag();
        Toast.makeText(mContext, itemEntity.name, Toast.LENGTH_SHORT).show();
    }

    /**
     * viewHolder
     */
    static class ViewHolder {
        public ImageView bgIV1, bgIV2, bgIV3, bgIV4, bgIV5, bgIV6, bgIV7,
                bgIV8, bgIV9, bgIV10;
        public TextView titleTV1, titleTV2, titleTV3, titleTV4, titleTV5,
                titleTV6, titleTV7, titleTV8, titleTV9, titleTV10;
        public RelativeLayout itemRL1, itemRL2, itemRL3, itemRL4, itemRL5,
                itemRL6, itemRL7, itemRL8, itemRL9, itemRL10;

        public ViewHolder(View itemView) {
            bgIV1 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_one);
            titleTV1 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_one);
            bgIV2 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_two);
            titleTV2 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_two);
            bgIV3 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_three);
            titleTV3 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_three);
            bgIV4 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_four);
            titleTV4 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_four);
            bgIV5 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_five);
            titleTV5 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_five);
            bgIV6 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_six);
            titleTV6 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_six);
            bgIV7 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_seven);
            titleTV7 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_seven);
            bgIV8 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_eight);
            titleTV8 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_eight);
            bgIV9 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_nine);
            titleTV9 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_nine);
            bgIV10 = (ImageView) itemView
                    .findViewById(R.id.fragment_music_singer_item_image_iv_ten);
            titleTV10 = (TextView) itemView
                    .findViewById(R.id.fragment_music_singer_item_name_tv_ten);
            itemRL1 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_one);
            itemRL2 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_two);
            itemRL3 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_three);
            itemRL4 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_four);
            itemRL5 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_five);
            itemRL6 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_six);
            itemRL7 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_seven);
            itemRL8 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_eight);
            itemRL9 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_nine);
            itemRL10 = (RelativeLayout) itemView
                    .findViewById(R.id.fragment_music_singer_item_ten);
        }
    }

}
