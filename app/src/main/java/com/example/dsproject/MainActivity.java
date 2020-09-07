package com.example.dsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neovisionaries.ws.client.ThreadType;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.neovisionaries.ws.client.WebSocketListener;
import com.neovisionaries.ws.client.WebSocketState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    ArrayList<ToyItem> toysArrayList;
    TextView myCost;
    Button myButton;
    WebSocket webSocketClient;
    ToyItem clickedToy;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardView = findViewById(R.id.cardView);
        myCost = findViewById(R.id.cost);

        RecyclerView myRecyclerView = findViewById(R.id.MyRecyclerView);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        toysArrayList = new ArrayList<>();
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(toysArrayList, new RecyclerViewAdapter.CartButtonListener() {
            @Override
            public void cartbtnClick(View v, int position) {
                clickedToy = toysArrayList.get(position);
                sendMessage();
            }
        });
        myRecyclerView.setAdapter(myAdapter);

        prepareToysData();
        createWebSocketClient();
    }


    private void prepareToysData() {
        ToyItem toyItem = new ToyItem(1,"Water Gun",
                "Lorem ipsum dolor sit amet, consectetur.",205,
                "27/07/2020",1234);
        toysArrayList.add(toyItem);

        toyItem = new ToyItem(2,"Football",
                "Lorem ipsum dolor sit amet, consectetur.",201,
                "27/07/2020",1235);
        toysArrayList.add(toyItem);

        toyItem = new ToyItem(3,"Skateboard",
                "Lorem ipsum dolor sit amet, consectetur.",206,
                "27/07/2020",1236);
        toysArrayList.add(toyItem);

        toyItem = new ToyItem(4,"Lego",
                "Lorem ipsum dolor sit amet, consectetur.",202,
                "27/07/2020",1237);
        toysArrayList.add(toyItem);

    }
    private void createWebSocketClient() {

        WebSocketFactory factory = new WebSocketFactory().setConnectionTimeout(5000);
        try {
            webSocketClient= factory.createSocket("ws://192.168.0.170:8080/test")
                    .addListener(new WebSocketListener() {
                        @Override
                        public void onStateChanged(WebSocket websocket, WebSocketState newState) throws Exception {
                        }

                        @Override
                        public void onConnected(WebSocket websocket, Map<String, List<String>> headers) throws Exception {

                        }

                        @Override
                        public void onConnectError(WebSocket websocket, WebSocketException cause) throws Exception {
                            Log.i("WebSocket", "Failed to connect....");
                        }

                        @Override
                        public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {
                            Log.i("WebSocket", "Disconnected....");
                        }

                        @Override
                        public void onFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onContinuationFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onTextFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onBinaryFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onCloseFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onPingFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onPongFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }


                        @Override
                        public void onTextMessage(WebSocket websocket, String text) throws Exception {
                            //todo dispaly the cost of the item on the card view
                            Log.i("WebSocket","Message received");
                            final String message = text;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //get response from server and display it on the app interface.
                                    try {
                                        myCost.setText(message);

                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            });
                            Log.i("WebSocket",  "From Server:" + text);

                        }

                        @Override
                        public void onTextMessage(WebSocket websocket, byte[] data) throws Exception {

                        }

                        @Override
                        public void onBinaryMessage(WebSocket websocket, byte[] binary) throws Exception {

                        }

                        @Override
                        public void onSendingFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onFrameSent(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onFrameUnsent(WebSocket websocket, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onThreadCreated(WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {

                        }

                        @Override
                        public void onThreadStarted(WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {

                        }

                        @Override
                        public void onThreadStopping(WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {

                        }

                        @Override
                        public void onError(WebSocket websocket, WebSocketException cause) throws Exception {
                            Log.i("WebSocket", "Failed due to...." + cause);
                        }

                        @Override
                        public void onFrameError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {

                        }

                        @Override
                        public void onMessageError(WebSocket websocket, WebSocketException cause, List<WebSocketFrame> frames) throws Exception {

                        }

                        @Override
                        public void onMessageDecompressionError(WebSocket websocket, WebSocketException cause, byte[] compressed) throws Exception {

                        }

                        @Override
                        public void onTextMessageError(WebSocket websocket, WebSocketException cause, byte[] data) throws Exception {
                            Log.i("WebSocket", "Failed due to...." + cause);
                        }

                        @Override
                        public void onSendError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {
                            Log.i("WebSocket", "Failed to send message due to...." + cause);
                        }

                        @Override
                        public void onUnexpectedError(WebSocket websocket, WebSocketException cause) throws Exception {
                            Log.i("WebSocket", "Failed due to...." + cause);
                        }

                        @Override
                        public void handleCallbackError(WebSocket websocket, Throwable cause) throws Exception {

                        }

                        @Override
                        public void onSendingHandshake(WebSocket websocket, String requestLine, List<String[]> headers) throws Exception {

                        }

                    });
            webSocketClient.connectAsynchronously();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void sendMessage() {
        if (webSocketClient.isOpen()) {
            Log.i("WebSocket","Button was clicked");
            //todo instead of sending the toy price alone, send all toy info..
            String jsonData = gson.toJson((clickedToy.getToyPrice()));
            webSocketClient.sendText(jsonData);
            Toast.makeText(getApplicationContext(),"Added to cart",Toast.LENGTH_LONG).show();
        }
    }


}