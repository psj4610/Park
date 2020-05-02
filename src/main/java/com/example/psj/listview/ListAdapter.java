package com.example.psj.listview;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListAdapter extends BaseAdapter {

    Context     context;


    String[] titles = {"영화제목1","영화제목2","영화제목3","영화제목4",
            "영화제목5","영화제목6","영화제목7"};
    Integer[] images = {R.drawable.movie1, R.drawable.movie2, R.drawable.movie3,
            R.drawable.movie4, R.drawable.movie5, R.drawable.movie6, R.drawable.movie7};

    public ListAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.listitem, null, true);

        ImageView image = (ImageView)v.findViewById(R.id.image);
                TextView title = (TextView)v.findViewById(R.id.title);
                TextView rating = (TextView)v.findViewById(R.id.rating);
                TextView genre = (TextView)v.findViewById(R.id.genre);
                TextView year = (TextView)v.findViewById(R.id.year);

                image.setImageResource(images[position]);
                title.setText(titles[position]);
                rating.setText("9.0"+position);
                genre.setText("DRAMA"+position);
                year.setText(1930+position+"");


                v.setOnClickListener(new View.OnClickListener() {
                    final int pos = position;
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                        View dialog = (View) View.inflate(context,R.layout.dialog,null);
                        ImageView dlgiv = (ImageView) dialog.findViewById(R.id.iv);


                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlgiv.setImageResource(images[pos]);
                        dlg.setTitle(titles[pos]);
                        dlg.setView(dialog);
                        dlg.setNegativeButton("닫기",null);

                dlg.show();

        }
        });

        return v;
    }

}
