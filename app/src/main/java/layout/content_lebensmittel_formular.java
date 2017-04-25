package layout;

import android.app.Fragment;

import com.healthservices.mha.momole.R;

public class content_lebensmittel_formular extends Fragment {
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_lebensmittel_formular);

        findViewById(R.id.button_lebensmittel_speichern).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bezeichnung = ((TextView) findViewById(R.id.input_lebensmittel_bezeichnung)).getText().toString();
                String uhrzeit = ((TextView) findViewById(R.id.input_lebensmittel_uhrzeit)).getText().toString();
                if (uhrzeit.length() != 0) {
                    try {
                        MomoleDAO lebensmittel = new lebensmittel();
                        lebensmittel.setBezeichnung(bezeichnung);
                        lebensmittel.setUhrzeit(uhrzeit);
                        MomoleDAO.getInstance(content_lebensmittel_formular.this).addLebensmittel(Lebensmittel);
                        Toast.makeText(PaymentActivity.this, R.string.save_payment_message, Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (NumberFormatException e) {
                        Toast.makeText(PaymentActivity.this, R.string.amount_missing, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(PaymentActivity.this,
                            R.string.amount_missing, Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }*/
}
