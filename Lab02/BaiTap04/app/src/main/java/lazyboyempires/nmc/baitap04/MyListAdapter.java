package lazyboyempires.nmc.baitap04;
import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] mainTitle;
    private final String[] subtitle;
    private final Integer[] imgID;

    public MyListAdapter(Activity context, String[] mainTitle,String[] subtitle, Integer[] imgID) {
        super(context, R.layout.mylist, mainTitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.mainTitle=mainTitle;
        this.subtitle=subtitle;
        this.imgID=imgID;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(mainTitle[position]);
        imageView.setImageResource(imgID[position]);
        subtitleText.setText(subtitle[position]);

        return rowView;

    };
}
