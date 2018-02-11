package com.example.rilak.demo1;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mDragItem;
    private TextView mDropArea;
    private TextView mDragInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDragItem = findViewById(R.id.drag_item);
        mDropArea = (TextView) findViewById(R.id.drop_area);
        mDragInfo = (TextView) findViewById(R.id.drag_info);

        mDragItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData data = ClipData.newPlainText("label", "DragItem");

                mDragItem.startDrag(data, new View.DragShadowBuilder(mDragItem), null, 0);

                return true;
            }
        });

        mDropArea.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:

                        mDropArea.setText("ACTION_DRAG_STARTED");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        mDropArea.setText(
                                String.format("ACTION_DRAG_ENTERED : %8.3f,%8.3f",
                                        event.getX(), event.getY()));
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                     mDropArea.setText(
                             String.format("ACTION_DRAG_EXITED : %8.3f,%8.3f",
                                          event.getX(),event.getY()));
                         break;
                     case DragEvent.ACTION_DROP:
                      mDropArea.setText(
                              String.format("ACTION_DROP : %8.3f, %8.3f",
                                             event.getX(),event.getY()));
                          break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        mDropArea.setText(
                                String.format("ACTION_DRAG_LOCATION : %8.3f,%8.3f",
                                               event.getX(),event.getY()));
                          break;
                }
                return true;
            }

        });

        mDragInfo.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        mDragInfo.setText("ACTION_DRAG_STARTED");
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        mDragInfo.setText("ACTION_DRAG_ENDED");
                        break;
                }

                return true;

            }


        });
    }

}
