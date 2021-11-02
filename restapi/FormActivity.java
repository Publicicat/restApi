package com.publicicat.restapi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    EditText etEmail, etMessage, etPassword;
    Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        ImageView dots = findViewById(R.id.right_icon);
        dots.setVisibility(View.GONE);

        ImageView back = findViewById(R.id.left_icon);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(FormActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });


        etMessage = findViewById(R.id.et_Message);
        etEmail = findViewById(R.id.et_Email);
        btnSend = findViewById(R.id.btn_Send);
        //etPassword = findViewById(R.id.et_Password);


        //Send Email from your email provider with input data from here: start
        //From: yoursTRULY
        //https://www.youtube.com/watch?v=WhGICo-lxz0
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] TO_EMAILS = {"example@gmail.com", "a@a.com"};
                String[] CC = {"example@gmail.com", "a@a.com"};
                String[] BCC = {"example@gmail.com", "a@a.com"};

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
                intent.putExtra(Intent.EXTRA_CC, CC);
                intent.putExtra(Intent.EXTRA_BCC, BCC);

                intent.putExtra(Intent.EXTRA_SUBJECT, "This is the subject");
                intent.putExtra(Intent.EXTRA_TEXT, "This is the body of the email");

                startActivity(Intent.createChooser(intent, "Choose an app"));
            }
        });

    }

        /*
        //Send Email to yourself: start
        //Manifest file modified to get permissions
        //From: TechSupportNep
        // https://www.youtube.com/watch?v=roruU4hVwXA
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username=etEmail.getText().toString();
                //final String password=etPassword.getText().toString();
                String messageToSend=etMessage.getText().toString();
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                Session session=Session.getInstance(props,
                        new javax.mail.Authenticator(){

                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });
                try {
                    Message message = new MimeMessage(messageToSend);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(etEmail.getText().toString()));
                    message.setSubject("Sending email without opening gmail apps");
                    message.setText(messageToSend);
                    Transport.send(message);
                    Toast.makeText(getApplicationContext(), "email sent successfully", Toast.LENGTH_SHORT).show();

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }


            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }*/

}