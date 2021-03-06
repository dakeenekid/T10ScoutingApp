package nhs_t10.helloworld;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void writeData(View view) {
        System.out.println("Reading data...");
        System.out.println("Writing to phone...");
        BufferedWriter bufferWriter = null;
        int i = (int) (Math.random()*10000);
        try {

            FileOutputStream fileOutputStream = openFileOutput("ScoutingData" + i +".txt", Context.MODE_PRIVATE);

            bufferWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferWriter.write(Boolean.toString(((Switch) this.findViewById(R.id.switch1)).isChecked()));
            bufferWriter.write(Boolean.toString(((Switch) this.findViewById(R.id.switch2)).isChecked()));
            bufferWriter.write(Boolean.toString(((CheckBox) this.findViewById(R.id.checkBox)).isChecked()));
            bufferWriter.write(Boolean.toString(((CheckBox) this.findViewById(R.id.checkBox2)).isChecked()));
            bufferWriter.write(Boolean.toString(((CheckBox) this.findViewById(R.id.checkBox3)).isChecked()));
            bufferWriter.write(Boolean.toString(((CheckBox) this.findViewById(R.id.checkBox4)).isChecked()));
            bufferWriter.write(Boolean.toString(((CheckBox) this.findViewById(R.id.checkBox5)).isChecked()));


            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();



        } finally {
            try {
                bufferWriter.close();
            } catch (IOException e) {
                e.printStackTrace();

            }

        }
        readData(i);
    }

    public void readData(int i) {
        System.out.println("Reading data");
        BufferedReader in;
        try {
            FileInputStream fis = openFileInput("ScoutingData" + i + ".txt");
            in = new BufferedReader(new InputStreamReader(fis));
            String input = "";
            String f = "";
            while ((input = in.readLine()) != null) {
                f += input + "\n";
            }
            System.out.println(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

