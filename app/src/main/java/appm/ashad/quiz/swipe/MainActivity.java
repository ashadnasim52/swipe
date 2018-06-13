package appm.ashad.quiz.swipe;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private slideadapter myadapter;
    List<String> mylistofquestion=new ArrayList<>();
    List<String> mylistofanswer=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new slideadapter(this);
        viewPager.setAdapter(myadapter);
        myjsonrequest();
    }

    //requesting for data
    public void myjsonrequest()
    {
        //url to make request
        String myurl="https://learncodeonline.in/api/android/datastructure.json";

        JsonObjectRequest myjsonObjectRequest=new JsonObjectRequest(Request.Method.GET, myurl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("response","is "+response);

                        try {

                            JSONArray jsonArrayofmine=response.getJSONArray("questions");


                            Log.i("jsonarray","is "+jsonArrayofmine);


                            for (int i=0;i<jsonArrayofmine.length();i++)
                            {
                                //taking quesstion and answer
                                JSONObject jsonObjectinarray=jsonArrayofmine.getJSONObject(i);

                                String question=jsonObjectinarray.getString("question");
                                String answer=jsonObjectinarray.getString("Answer");
                                mylistofquestion.add(i,question);
                                mylistofanswer.add(i,answer);

                            }
                            Log.i("mylistofquestion","is "+mylistofquestion);
                            Log.i("mylistofanswer","is "+mylistofanswer);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //show snackbar
            }
        }

        );
        mysingleton.getInstance(getApplicationContext()).addToRequestque(myjsonObjectRequest);


    }


}
