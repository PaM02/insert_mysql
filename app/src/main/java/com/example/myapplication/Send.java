package com.example.myapplication;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public   class Send extends AsyncTask<String, String, String> {

    //je declare les varriables globales dans cette classe
    public  String user="root";
    public  String passe="";
    public  String url="jdbc:mysql://51.75.250.106:81:3306/linkonprojet";
    String msg;
    String a;
    String text = MainActivity.editText.getText().toString();
    String text1 = MainActivity.editText1.getText().toString();
    String text2 = MainActivity.editText2.getText().toString();
    String text3 = MainActivity.editText3.getText().toString();
    String text4 = MainActivity.editText4.getText().toString();
    String text5 = MainActivity.editText5.getText().toString();

   /* String nomuser="dfdsfsd";
    String prenOm="dfdsfsd";
    String nOm="dfdsfsd";
    String passwordEncrypt="dfdsfsd";
    String edCompteur="dfdsfsd";*/
    int tEl=Integer.parseInt(text3);

    @Override
    protected void onPreExecute() {
        MainActivity.textView.setText("please wait inserting data");
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,passe);

            if ((connection == null)){

                msg = "connection goes wrong";

            }

            else {


                Statement statement = connection.createStatement();
                String query = "INSERT INTO client (username,prenom,nom,tel,password,numcompteur) VALUES ('"+text+"','"+text1+"','"+text2+"','"+tEl+"','"+text4+"','"+text5+"')";
                statement.executeUpdate(query);
                //String query = "select * from personne";
                //String query = "INSERT INTO personne (prenom,nom,etat) VALUES ('"+text+"','"+text2+"','"+text3+"')";

               /* ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                     a = resultSet.getString("prenom");
                }*/
                msg = "Inserting succeful";

            }

            connection.close();

        }
        catch (Exception e){

            msg = "il y'a un probleme de connexion";
            e.printStackTrace();

        }

        return msg;
    }

    @Override
    protected void onPostExecute(String msg) {

        MainActivity.textView.setText(msg);
    }

}
