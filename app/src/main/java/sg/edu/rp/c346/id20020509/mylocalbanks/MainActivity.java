package sg.edu.rp.c346.id20020509.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String bankClicked = "";
    Boolean blDBS, blOCBC, blUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);
        blDBS = true;
        blOCBC = true;
        blUOB = true;

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == tvDBS) {
            bankClicked = "DBS";
        }
        if (v == tvOCBC) {
            bankClicked = "OCBC";
        }
        if (v == tvUOB) {
            bankClicked = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(bankClicked.equalsIgnoreCase("dbs")) {
            if(id == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            }
            else if(id==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1+800+111+1111));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
            else if((id==2) && (blDBS)) { //check if the selected menu item ID is 1
                //code for action
                tvDBS.setTextColor(Color.parseColor("#FF0000"));
                blDBS = false;  //menu item successfully handled
            }
            else if((id==2) && (!blDBS)) { //check if the selected menu item ID is 1
                //code for action
                tvDBS.setTextColor(Color.parseColor("#000000"));
            }
        }
        else if(bankClicked.equalsIgnoreCase("ocbc")) {
            if(id == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true; //menu item successfully handled
            }
            else if(id==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1+800+363+3333));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
            else if((id==2) && (blOCBC)) { //check if the selected menu item ID is 1
                //code for action
                tvOCBC.setTextColor(Color.parseColor("#FF0000"));
                blOCBC = false;  //menu item successfully handled
            }
            else if((id==2) && (!blOCBC)) { //check if the selected menu item ID is 1
                //code for action
                tvOCBC.setTextColor(Color.parseColor("#000000"));
            }
        }
        else if(bankClicked.equalsIgnoreCase("uob")) {
            if(id == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            }
            else if(id==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1+800+222+2121));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
            else if((id==2) && (blUOB)) { //check if the selected menu item ID is 1
                //code for action
                tvUOB.setTextColor(Color.parseColor("#FF0000"));
                blUOB = false;  //menu item successfully handled
            }
            else if((id==2) && (!blUOB)) { //check if the selected menu item ID is 1
                //code for action
                tvUOB.setTextColor(Color.parseColor("#000000"));
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


}