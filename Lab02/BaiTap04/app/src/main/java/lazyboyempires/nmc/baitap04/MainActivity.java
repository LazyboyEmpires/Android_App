package lazyboyempires.nmc.baitap04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] mainTile ={
      "Tile1","Title2",
      "Tile3",
    };
    String[] subtitle = {
            "Sub Tile 1", "Sub Title 2",
            "Sub Tile 3",
    };
    Integer[] imgID = {
      R.drawable.mercury,R.drawable.venus,
      R.drawable.earth,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter = new MyListAdapter(this,mainTile,subtitle,imgID);
        list =(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }
                else if (position == 1) {
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}