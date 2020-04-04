package com.example.facedetection.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.facedetection.Model.FaceDetectionModel;
import com.example.facedetection.R;

import java.text.MessageFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FaceDetectionAdapter extends RecyclerView.Adapter<FaceDetectionAdapter.ViewHolder> {

    private List<FaceDetectionModel> faceDetectionModelList;
    private Context context;

    public FaceDetectionAdapter(List<FaceDetectionModel> faceDetectionModelList, Context context) {
        this.faceDetectionModelList = faceDetectionModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public FaceDetectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_face_detection,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceDetectionAdapter.ViewHolder holder, int position) {

        FaceDetectionModel faceDetectionModel=faceDetectionModelList.get(position);

        holder.text1.setText(MessageFormat.format("Face {0}", String.valueOf(faceDetectionModel.getId())));
        holder.text2.setText(MessageFormat.format("Face {0}", faceDetectionModel.getText()));
    }

    @Override
    public int getItemCount() {
        return faceDetectionModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text1,text2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1=itemView.findViewById(R.id.item_face_detection_textView1);
            text2=itemView.findViewById(R.id.item_face_detection_textView2);
        }
    }
}
