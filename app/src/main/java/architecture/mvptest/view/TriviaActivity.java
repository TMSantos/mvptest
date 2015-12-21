package architecture.mvptest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import architecture.mvptest.R;
import architecture.mvptest.presenter.PresenterHolder;
import architecture.mvptest.presenter.TriviaPresenter;
import architecture.mvptest.presenter.TriviaPresenterImpl;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TriviaActivity extends AppCompatActivity implements TriviaView{

    @Bind(R.id.tv_trivia_text)
    TextView tvTriviaText;
    @Bind(R.id.pb_network)
    ProgressBar pbNetworkBar;
    @Bind(R.id.btn_get_trivia_fact)
    Button btnTriviaButton;

    TriviaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = createPresenter();
        feedView();
    }

    public TriviaPresenter createPresenter() {
        TriviaPresenter presenter = PresenterHolder.getInstance().getPresenter(TriviaPresenter.class);

        if (presenter != null) {
            presenter.setView(this);
        } else {
            presenter = new TriviaPresenterImpl(this);
        }
        return presenter;
    }

    public void feedView(){
        pbNetworkBar.setVisibility(View.VISIBLE);
        presenter.getTriviaText();
    }

    @OnClick(R.id.btn_get_trivia_fact)
    public void onButtonClicked(View view){
        feedView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    @Override
    public void setTriviaText(String text) {
        hideBar();
        tvTriviaText.setText(text);
    }

    @Override
    public void onServerFailure(String error) {
        hideBar();
        tvTriviaText.setText(error);
    }

    @Override
    public void onNetworkFailure(String error) {
        hideBar();
        tvTriviaText.setText(error);
    }

    private void hideBar(){
        pbNetworkBar.setVisibility(View.GONE);
    }
}
