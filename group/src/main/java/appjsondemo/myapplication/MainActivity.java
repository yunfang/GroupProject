package appjsondemo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 一个组合经典算法
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private List<String> Permutation;
    private TextView id_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bu_id = (Button) findViewById(R.id.bu_id);
        id_tv = (TextView) findViewById(R.id.id_tv);
        bu_id.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bu_id:

                Permutation = new ArrayList<String>();
                String productGoodStr = "";

//                Map<Integer, List<String>> getmapList = adapter.getmapList();
                Map<Integer,List<String>> getmapList = new HashMap<Integer,List<String>>();
                List<String > list1 = new ArrayList<>();
                List<String > list2 = new ArrayList<>();
                list1.add("list1-1");
                list1.add("list1-2");

                list2.add("list2-1");
                list2.add("list2-2");
                list2.add("list2-3");

                getmapList.put(0, list1);
                getmapList.put(1,list2);


                List<List<String>> ls = new ArrayList<List<String>>();

                Iterator<Map.Entry<Integer, List<String>>> iterator = getmapList.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry<Integer, List<String>> next = iterator.next();
                    List<String> value = next.getValue();
                    ls.add(value);
                }

                permutation(ls,"");
                for(int i =0 ;i<Permutation.size();i++){
                    productGoodStr += Permutation.get(i)+";";
                }

                id_tv.setText(productGoodStr);
                System.out.println("--------"+productGoodStr);

                break;
        }
    }


    private  void permutation( List<List<String>> list,String preStr) {
        int size = list.size();
        if(1==size){
            for(int i=0; i<list.get(0).size(); i++) {
                Permutation.add(preStr + list.get(0).get(i));
            }
        }else{
            if(size != 0){
                List<String> permu = new ArrayList<String>(list.get(0));
                List<List<String>> now = new ArrayList<List<String>>(list);
                now.remove(0);
                for(int i=0; i<permu.size(); i++){
                    permutation(now, preStr +permu.get(i)+",");
                }
            }

        }
    }
}
