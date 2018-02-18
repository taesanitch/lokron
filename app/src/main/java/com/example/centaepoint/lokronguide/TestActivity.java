package com.example.centaepoint.lokronguide;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private TextView tvQuestion, tvScore, tvTimer;
    private Button ans1, ans2, ans3, ans4, btCheckAns;
    CountDownTimer cdt;
    List<Integer> ansUser;
    String[] question;
    String[][] ans;
    int[] checkAns;
    int i = 0;
    int score = 0;
    int time = 10000;
    private boolean pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        question = new String[]{"1.เฉลี่ยอุณหภูมิของโลกเพิ่มขึ้นในทุกปีกี่องศาเซลเซียส",
                "2.สภาวะโลกร้อนเกิดจากสาเหตุใด",
                "3.กิจกรรมที่มนุษย์ทำให้เกิดภาวะโลกร้อนข้อใดถูกต้องที่สุด",
                "4.อุณหภูมิของโลกสูงขึ้นเกิดจากสาเหตุใดเป็นหลัก",
                "5.ผลกระทบจากภาวะโลกร้อนข้อใดถูกต้องที่สุด",
                "6.ข้อใดคือผลกระทบจากภาวะโลกร้อนที่ทำให้ธรรมชาติเสียหาย",
                "7.ผลระทบจากภาวะโลกร้อนกับปรากฏการณ์ทางทะเลข้อใดถูกต้อง",
                "8.ผลกระทบจากภาวะโลกร้อนที่ส่งผลต่อการอุปโภคบริโภคของประชากรมากที่สุด",
                "9.ปรากฏการน้ำแข็งขั้วโลกละลายมีผลกับแหลงแม่น้ำทั่วโลกอย่างไร",
                "10.ผลกระทบจากภาวะโลกร้อนที่มีผลต่อระบบนิเวศท้องทะเล",
                "11.ข้อใดต่อไปนี้ส่งผลกระทบต่อร่างกายของมนุษย์มากที่สุดที่เกิดจากภาวะโลกร้อน",
                "12.ข้อใดต่อไปนี้ส่งผลกระทบต่อระบบเศรษฐ์กิจมากที่สุดที่เกิดจากภาวะโลกร้อน",
                "13.นักศึกษาไปซื้อกับข้าวที่ร้านสะดวกซื้อนักศึกษาจะมีวิธีช่วยลดโลกร้อนได้จากสิ่งใด",
                "14.นักศึกษาไปหาเพื่อนต่างที่นักศึกษาจะมีวิธีช่วยลดภาวะโลกร้อนได้อย่างไร",
                "15.ข้อใดต่อไปนี้ช่วยลดการผลิตที่ก่อให้เกิดภาวะโลกร้อน",
                "16.ข้อใดต่อไปนี้คือวิธีที่จะช่วยประหยัดพลังงานเพื่อช่วยลดโลกร้อน",
                "17.เมื่อเกิดภัยธรรมชาตินักศึกษาคิดว่าวิธีใดที่จะช่วยโลกเราได้ง่ายสุด",
                "18.เมื่อก๊าซเรือนกระจกสะสมบนโลกมากๆทำให้โลกเกิดการเปลี่ยนแปลงอย่างไร",
                "19.นักศึกษาคิดว่าข้อใดต่อนี้เป็นกิจกรรมช่วยให้โลกไม่ร้อน",
                "20.ข้อใดต่อไปนี้ผิด"};
        ans = new String[][]{{"1.1-6.4 องศาเซลเซียส", "2.4-3.6 องศาเซลเซียส", "0.1-0.4 องศาเซลเซียส ", "5.1-6.0 องศาเซลเซียส "},
                {"ก๊าซซัลเฟอร์ไดออกไซด์", "ก๊าซออกซิเจน ", "ก๊าซเรือนกระจก", "ก๊าซไนโตรเจน "},
                {"การหุงข้าวจากหม้อหุงข้าวไฟฟ้า", "การซักผ้าโดยใช้เครื่องซักผ้าไฟฟ้า", "การเผาผลาญถ่านหินและเชื้อเพลิง", "การทิ้งขยะไม่ลงถัง"},
                {"รังสีแกรมม่าในชั้นบรรยากาศ", "รังสีของดวงอาทิตย์ถูกกักเก็บอยู่บนโลก", "รังสีแอลฟ่าสะสมมากบนผิวโลก", "รังสีความร้อนจากกดวงอาทิตย์ที่สะท้อนออกไปนอกโลก"},
                {"อุณหภูมิติดลบ", "อุณหภูมิเปลี่ยนแปลงอย่างรวดเร็ว", " สัตว์ป่าอพยบถิ่นฐาน", "อาหารขาดแคลน"},
                {"เศรษฐกิจเสียหาย", "ป่าไม้ถูกทำลายพันธ์พืชบางชนิดสูญพันธ์", "พืชผลทางการเกษตรขาดแคลน", "ภัยแล้งและน้ำท่วมเกิดพายุรุนแรง"},
                {"น้ำทะเลลดลงอย่างกะทันหัน", "น้ำทะเลสูงขึ้นในแถบชายฝัง", "น้ำทะเลหนุนสูงบริเวณปากแม่น้ำ", "น้ำทะเลเพิ่มสูงขึ้นในแถบทะเลน้ำจืด"},
                {"ภัยแล้งทำให้พืชผลล้มตายลง", "ภัยแล้งทำให้ผลผลิตทางการกระเกษตรเกิดน้อยลง", "ภัยแล้งทำลายผลิตผลทางการเกษตร", "ถูกทุกข้อที่กล่าวมา"},
                {"ปริมาณน้ำในมหาสมุทรปนเปื้อนสารพิษ", "น้ำในทะเลแถบต่างๆลดลงอย่างรวดเร็ว", "ปริมาณน้ำทั่วโลกลดลง", "ปริมาณน้ำทั่วโลกสูงขึ้น"},
                {"สัตว์น้ำหลายตัวย้ายถิ่นที่อยู่เดิม", "ทำให้สัตว์นำปรับตัวไม่ได้และเสียชีวิตในที่สุด", "ระบบนิเวศใต้ท้องทะเลมีการผลิตออกซิเจนเพิ่มขึ้น", "มีการเพิ่มจำนวนของแพลงก์ตอนทะเล"},
                {"อุณหภูมิภายในบ้านเรือนร้อนขึ้น", "ภัยพิบัติต่างๆที่เกิดขึ้นทำให้การดำรงชีวิตของมนุษย์ยากลำบาก", "เป็นโรคท้องล่วงจาการรับประทานของที่สกปรก", "มีจำนวนประชาการมนุษย์ลดลง"},
                {"ภัยพิบัติที่รุนแรงเกิดความเสียหายต่อระบบเศรษฐกิจและความไม่เชื่อมั่นของผู้ลงทุน", "โรงงานอุตสาหกรรมลดการผลิตน้อยลง", "เศรษฐกิจทรงตัว", "ขั้นตอนการผลิตเพิ่มสูงขึ้นจากความต้องการของมนุษย์"},
                {"ซื้อของโดยให้แม้ค้าใส่ถุงพลาสติกให้", "ซื้อของโดยพกถุงผ้าไว้ใส่ของ", "ทิ้งถุงพลาสติกลงพื้นหลังจากแกะถุงกับข้าว", "บอกแม้ค้าว่าขอใส่แยกถุงพลาสติกเมื่อซื้อกับข้าวสองอย่าง"},
                {"โบกวินมอไซท์ให้ไปส่งที่บ้านเพื่อน", "โดยสารรถประจำทางไปหาเพื่อน", "ปั่นจักรยานไปหาเพื่อน", "ขับรถไปหาเพื่อนด้วยตัวเอง"},
                {"ใช้ผ้าเช็ดหน้าส่วนตัวที่พกมา", "ซื้อกระดาษทิชชู่ที่ร้านสะดวกซื้อ", "ซื้อน้ำป่าวจากร้านสะดวกซื้อ", "ซื้ออาหารใส่กล่องโฟมแทนการห่อข้าวมากินเอง"},
                {"ใช้เตาแก๊สแทนการใช้ไมโครเวฟ", "เปิดโคมไฟเมื่อทำธุระเพียงเล็กน้อยแทนการเปิดไฟดวงใหญ่", "ดูทีวีผ่านคอมพิวเตอร์แทนการเปิดทีวี", "ดึงปลั๊กสายชาร์จเมื่อชาร์จโทรศัพท์เต็มแล้ว"},
                {"ปลูกต้นไม้", "ให้อาหารสัตว์", "เลี้ยงสัตว์ไว้บอกเหตุภัยธรรมชาติ", "ย้ายบ้านจากแหล่งเสี่ยงต่อภัยธรรมชาติ"},
                {"ก๊าซเสียสะสมอยู่บนผิวโลก", "ก๊าซเรื่อนกระจกสะท้อนภายในชั้นบรรยากาศโลก", "อุณหภูมิเพิ่มสูงขึ้นเกิดความเสี่ยงจากภัยธรรมชาติ", "ผิดทุกข้อ"},
                {"ขึ้นรถเพื่อไปออกกำลังกายที่ฟิตเนส", "ชวนเพื่อนมาติวหนังสือที่สวนสาธารณะใกล้บ้าน", "ติดเครื่องทำความเย็นเพิ่มที่บ้าน", "ขับรถไปร้องเพลงคาราโอเกะที่ห้าง"},
                {"การคัดแยกขยะเป็นอีก1วิธีที่จะช่วยโลกเราได้", "การเดินไปทำธุระหรือปั่นจักรยานแทนการขับรถช่วยลดโลกร้อนได้", "โรงงานอุสาหกรรมเกือบทุกแห่งไม่มีการควบคุมการปล่อยมลพิษ", "แค่เราปลูกต้นไม้วันละ1ต้นก็ช่วยต่ออายุโลกเราได้1ปี"},

        };
        checkAns = new int[]{1, 3, 3, 2, 2, 2, 3, 4, 4, 2, 3, 1, 2, 3, 1, 4, 1, 3, 2, 3};
        ansUser = new ArrayList<>();
        pause = false;
        tvQuestion = (TextView) findViewById(R.id.question);
        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
        ans4 = (Button) findViewById(R.id.ans4);
        tvScore = (TextView) findViewById(R.id.tvScore);
        tvTimer = (TextView) findViewById(R.id.timer);
        countDown();
        btCheckAns = (Button) findViewById(R.id.btCheckAns);
        btCheckAns.setVisibility(View.GONE);
        updateQuestion(i);

        ans1.setOnClickListener(listener);
        ans2.setOnClickListener(listener);
        ans3.setOnClickListener(listener);
        ans4.setOnClickListener(listener);
        btCheckAns.setOnClickListener(listener);

    }

    private void countDown() {
        cdt = new CountDownTimer(time, 50) {
            @Override
            public void onTick(long l) {
                if (pause) {
                    cancel();
                } else {
                    String time = String.format("%.1f", (double) l / 1000);
                    tvTimer.setText(time);
                }
            }

            @Override
            public void onFinish() {
                ansUser.add(5);
                i += 1;
                updateQuestion(i);
                start();
            }
        }.start();
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == ans1) {
                cdt.cancel();
                ansUser.add(1);
                i += 1;
                updateQuestion(i);
                cdt.start();
            } else if (view == ans2) {
                cdt.cancel();
                ansUser.add(2);
                i += 1;
                countDown();
                Log.e("i", i + "");
                updateQuestion(i);
                cdt.start();

            } else if (view == ans3) {
                cdt.cancel();
                ansUser.add(3);
                i += 1;
                Log.e("i", i + "");
                updateQuestion(i);
                cdt.start();
            } else if (view == ans4) {
                cdt.cancel();
                ansUser.add(4);
                i += 1;
                Log.e("i", i + "");
                updateQuestion(i);
                cdt.start();
            } else if (view == btCheckAns) {
                Intent intent = new Intent(TestActivity.this, ScoreActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("size", question.length);
                startActivity(intent);
                finish();
            }
        }
    };

    private void updateQuestion(int i) {
        if (i < question.length) {
            tvQuestion.setText(question[i]);
            Log.e("ans", ans[i][0] + "," + ans[i][1] + "," + ans[i][2] + "," + ans[i][3]);
            ans1.setText(ans[i][0]);
            ans2.setText(ans[i][1]);
            ans3.setText(ans[i][2]);
            ans4.setText(ans[i][3]);

        }
        if (i <= question.length) {
            if (ansUser.size() > 0) {
                if (ansUser.get(i - 1) == (checkAns[i - 1])) {
                    score += 1;
                }
            }
            if (i == question.length) {
                btCheckAns.setVisibility(View.VISIBLE);
                pause = true;
            }
            tvScore.setText("Score:" + score);
        }
    }
}
