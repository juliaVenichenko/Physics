package com.mygdx.game.screens.gpt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class NetworkTask {

    private static final String OPENAI_API_KEY = "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"; // 🔐 Вставь сюда свой ключ
    private static final String OPENAI_API_URL = "https://openrouter.ai/api/v1/chat/completions";

    public void askOpenAI(String question, final ResponseListener listener) {
        String jsonBody = "{\"model\": \"deepseek/deepseek-chat:free\", " +
                "\"messages\": [{\"role\": \"user\", \"content\": \"" + question + "\"}]}";

        Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.POST);
        request.setUrl(OPENAI_API_URL);
        request.setHeader("Authorization", "Bearer " + OPENAI_API_KEY);
        request.setHeader("Content-Type", "application/json");
        request.setContent(jsonBody);

        Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseString = httpResponse.getResultAsString();
                JsonValue jsonResponse = new JsonReader().parse(responseString);
                String answer = jsonResponse.get("choices").get(0).get("message").getString("content").trim();
                listener.onSuccess(answer);
            }

            @Override
            public void failed(Throwable t) {
                listener.onError(t.getMessage());
            }

            @Override
            public void cancelled() {
                listener.onError("Request cancelled");
            }
        });
    }

    public interface ResponseListener {
        void onSuccess(String response);
        void onError(String error);
    }
}
