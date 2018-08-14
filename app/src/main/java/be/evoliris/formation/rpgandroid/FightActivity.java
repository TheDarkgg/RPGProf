package be.evoliris.formation.rpgandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import be.evoliris.formation.rpgandroid.factories.PersonnageFactory;
import be.evoliris.formation.rpgandroid.models.Personnage;

public class FightActivity extends AppCompatActivity implements View.OnClickListener {
    private Personnage player,  monster;
    private ProgressBar hpPlayer, hpMonster;
    private Button btnAttack, btnHeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        btnAttack = (Button)findViewById(R.id.btn_attack);
        btnHeal = (Button)findViewById(R.id.btn_heal);

        btnHeal.setOnClickListener(this);
        btnAttack.setOnClickListener(this);

        Bundle extras = this.getIntent().getExtras();
        if(extras == null)throw new RuntimeException("FightActivity.onCreate(Bundle)");

        hpPlayer = (ProgressBar)findViewById(R.id.vertical_progressbar_player);
        hpMonster = (ProgressBar)findViewById(R.id.vertical_progressbar_monster);

        String classe = extras.getString(Constants.Intent.CHARACTER_EXTRA);
        String name = extras.getString(Constants.Intent.NAME_EXTRA);

        assert classe != null;
        this.player = PersonnageFactory.createPersonnage(name, classe);
        this.monster = PersonnageFactory.createPersonnage("Dragon", "Elfe");

        hpMonster.setMax(this.monster.getHp());
        hpPlayer.setMax(this.player.getHp());
        hpMonster.setProgress(this.monster.getHp());
        hpPlayer.setProgress(this.player.getHp());

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_attack: attackAction(); break;
        }

    }
    private void attackAction(){
        this.player.attack(monster);
        this.monster.attack(player);

        hpMonster.setProgress(this.monster.getHp());
        hpPlayer.setProgress(this.player.getHp());
    }
}
