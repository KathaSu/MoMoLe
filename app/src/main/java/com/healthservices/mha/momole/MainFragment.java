package com.healthservices.mha.momole;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.healthservices.mha.momole.database.model.Beschwerden;
import com.healthservices.mha.momole.database.model.Lebensmittel;
import com.healthservices.mha.momole.database.model.Notizen;
import com.healthservices.mha.momole.database.BeschwerdenDAO;
import com.healthservices.mha.momole.database.LebensmittelDAO;
import com.healthservices.mha.momole.database.NotizenDAO;


public class MainFragment extends Fragment {

    private ListView listView;
    //private PaymentAdapter listAdapter;
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*listView = (ListView) view.findViewById(R.id.mainPaymentsList);
        listAdapter = new PaymentAdapter();
        listView.setAdapter(listAdapter);*/

    }

    @Override
    public void onResume() {
        super.onResume();
        //listAdapter.notifyDataSetChanged();
    }

    /*private class PaymentAdapter extends BaseAdapter {

        private List<Payment> payments;

        private PaymentAdapter() {
            payments = PaymentDAO.getInstance(getContext()).getAllPayments();
        }

        @Override
        public int getCount() {
            return payments.size();
        }

        @Override
        public Payment getItem(int position) {
            return payments.get(position);
        }

        @Override
        public long getItemId(int position) {
            return payments.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null)
                convertView = layoutInflater.inflate(R.layout.row_payment, null);

            TextView category = (TextView) convertView.findViewById(R.id.rowPaymentCategory);
            TextView time = (TextView) convertView.findViewById(R.id.rowPaymentTime);
            TextView amount = (TextView) convertView.findViewById(R.id.rowPaymentAmount);

            Payment payment = getItem(position);

            category.setText(payment.getCategory());
            time.setText(formatDate(payment.getTime()));
            amount.setText(String.valueOf(payment.getAmount()));

            return convertView;
        }

        @Override
        public void notifyDataSetChanged() {
            payments = PaymentDAO.getInstance(getContext()).getAllPayments();
            super.notifyDataSetChanged();
        }

        private String formatDate(long timestamp) {
            return dateFormat.format(new Date(timestamp));
        }
    }*/

}
