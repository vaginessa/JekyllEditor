package uk.co.a247a.jekylleditor.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import uk.co.a247a.jekylleditor.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WebPreview.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WebPreview#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebPreview extends Fragment {
    // TODO: 22/07/2017  Add nav bar, and url bar. Nav bar to include home back and forward

    private static final String ARG_HOME_URL = "homeURL";


    private String mHomeURL;
    private String mCurrentURL;
    private WebView mWebView;

    public WebPreview() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param homeURL Parameter 1.
     * @return A new instance of fragment WebPreview.
     */
    // TODO: Rename and change types and number of parameters
    public static WebPreview newInstance(String homeURL) {
        WebPreview fragment = new WebPreview();
        Bundle args = new Bundle();
        args.putString(ARG_HOME_URL, homeURL);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHomeURL = getArguments().getString(ARG_HOME_URL);
            mCurrentURL = mHomeURL;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_web_preview, container, false);

        //Set up webview
        mWebView = v.findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                mCurrentURL = url;
                super.onPageFinished(view, url);
            }
        });
        mWebView.getSettings().getDisplayZoomControls();
        mWebView.loadUrl(mCurrentURL);

        //return the inflated view for fragment
        return v;
    }
}
