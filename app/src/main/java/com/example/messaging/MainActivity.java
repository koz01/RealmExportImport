package com.example.messaging;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RealmUtil.RealmBackupRestore;
import RealmUtil.RealmConfigSetting;
import io.realm.Realm;

public class MainActivity extends Activity {
    Realm realm;
    Context context;
    private SimpleAdapter adapter;
    private ArrayList<Employee> msgList;
    EmployeeRepo empRepo;
    private ArrayList<HashMap<String, Object>> list;
    ListView lvShow;
    List<Employee> empList;
    Employee emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        RealmConfigSetting realmConfig = new RealmConfigSetting(context);
        realmConfig.RealmConfigSetting();


        realm = Realm.getDefaultInstance();
        empRepo = new EmployeeRepoImpl();
        lvShow = (ListView) findViewById(R.id.lvShow);
        final RealmBackupRestore realmBackupRestore = new RealmBackupRestore(this);

        Button btnBackUp = (Button) findViewById(R.id.btnBackup);
        Button btnRestore = (Button) findViewById(R.id.btnRestor);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        Button btnInsert = (Button) findViewById(R.id.btnInsert);
        final Button btnRefresh = (Button) findViewById(R.id.btnrefresh);
        final TextView tvBackupPath = (TextView) findViewById(R.id.tvBackupPath);
        final TextView tvRestore = (TextView) findViewById(R.id.tvRestorePath);

        btnBackUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realmBackupRestore.backup();
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Refresh();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empRepo.clear(realm);
                Refresh();
            }
        });

        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realmBackupRestore.restore();
                Refresh();
            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBind();

                for (int i = 0; i < empList.size(); i++) {
                    emp = new Employee();
                    emp.setId(empList.get(i).getId());
                    emp.setName(empList.get(i).getName());
                    emp.setCode(empList.get(i).getCode());
                    emp.setDepartment(empList.get(i).getDepartment());
                    empRepo.saveOrUpdate(realm, emp);
                }

                Refresh();
            }
        });

        long count = empRepo.getCount(realm);

        if (count > 0) {
            Toast.makeText(context, "Data Exist", Toast.LENGTH_SHORT).show();

        }
        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("BackUp");
        spec.setContent(R.id.backup);
        spec.setIndicator("BackUp");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Restore");
        spec.setContent(R.id.restore);
        spec.setIndicator("Restore");
        host.addTab(spec);

    }

    private void dataBind() {
        empList = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Kyaw Zin Oo");
        emp.setCode("KZO001");
        emp.setDepartment("Software Engineer");
        empList.add(emp);

        emp = new Employee();
        emp.setId(2);
        emp.setName("Shwe Yee Htoo");
        emp.setCode("SYH001");
        emp.setDepartment("Software Engineer");
        empList.add(emp);

        emp = new Employee();
        emp.setId(3);
        emp.setName("Nang Mwe Khan");
        emp.setCode("NAN001");
        emp.setDepartment("Consualt");
        empList.add(emp);

        emp = new Employee();
        emp.setId(4);
        emp.setName("Nay Nang Ye");
        emp.setCode("NNY001");
        emp.setDepartment("Accounted");
        empList.add(emp);

        emp = new Employee();
        emp.setId(5);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(6);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(7);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(8);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(9);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(10);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(11);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(12);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(13);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(14);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(15);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(16);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(17);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(18);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(19);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(20);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(21);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(22);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(23);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(24);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(25);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(26);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(27);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(28);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(29);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(30);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(31);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(32);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(33);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(34);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(35);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(36);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

        emp = new Employee();
        emp.setId(37);
        emp.setName("May Moe Thwe Khaing");
        emp.setCode("MMTK001");
        emp.setDepartment("Finance");
        empList.add(emp);

    }

    private void Refresh(){

        msgList = empRepo.getfindAll(realm);
        list = empRepo.populateList(msgList);

        adapter = new SimpleAdapter(this, list, R.layout.msg_row_view,
                new String[]{"Name", "Code", "id"},
                new int[]{R.id.text1, R.id.text2});
        adapter.notifyDataSetChanged();
        lvShow.setAdapter(adapter);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
