package appm.ashad.quiz.swipe;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class slideadapter extends PagerAdapter{

    private Context mContext;
    private ArrayList<additem> mExampleList;
    LayoutInflater inflater;
    //list of image
    int images[]={R.drawable.bulbblue,R.drawable.bulbgreen,R.drawable.circle,R.drawable.cross};
    //lisst of title
    public String[] titleqw={"aaasdasdas","yuyui","third","fourth"};
    //list of desscription
    public String[] descriptionqw={"one","two","three","four"};

    //list of background color
    public int[] backgroundcolor={
            Color.rgb(55,55,55),
            Color.rgb(5,5,35),
            Color.rgb(55,55,25),
            Color.rgb(85,155,5)
    };





    public slideadapter(Context context, ArrayList<additem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }




    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return backgroundcolor.length;
    }

    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by {@link #, int)}. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view   Page View to check for association with <code>object</code>
     * @param object Object to check for association with <code>view</code>
     * @return true if <code>view</code> is associated with the key object <code>object</code>
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position  The page position to be removed.
     * @param object    The same object that was returned by
     *                  {@link #instantiateItem(View, int)}.
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);    }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position  The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater=(LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.linearlayout);

        additem currentItem = mExampleList.get(position);


        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        ImageView imgslide = (ImageView)  view.findViewById(R.id.imageviewofus);
        TextView txttitle= (TextView) view.findViewById(R.id.texta);
        TextView description = (TextView) view.findViewById(R.id.textb);
        layoutslide.setBackgroundColor(backgroundcolor[position]);
        container.addView(view);
        return view;
    }
}
