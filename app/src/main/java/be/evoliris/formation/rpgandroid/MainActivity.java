package be.evoliris.formation.rpgandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] characteres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCharacter = (ListView)findViewById(R.id.lv_select_player);

        this.characteres = new String[]{"Elfe", "Nain", "Humain"};

        lvCharacter.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, characteres));

        lvCharacter.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("POSITION", String.valueOf(position));
        EditText name = (EditText)findViewById(R.id.et_name);
        Bundle extras = new Bundle();
        extras.putString(Constants.Intent.CHARACTER_EXTRA, this.characteres[position]);
        extras.putString(Constants.Intent.NAME_EXTRA, name.getText().toString());

        Intent i = new Intent(this, FightActivity.class);
        i.putExtras(extras);

        startActivity(i);
    }
}
