package uk.co.a247a.jekylleditor.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import uk.co.a247a.jekylleditor.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FileBrowser.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FileBrowser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FileBrowser extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ROOT = "root";

    // TODO: Rename and change types of parameters
    private String mRoot;
    private String mCurrentDir;
    private OnFragmentInteractionListener mListener;
    private ListView mFolderView;
    private TextView mBreadCrums;

    public FileBrowser() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param rootDir Parameter 1.
     * @return A new instance of fragment FileBrowser.
     */
    // TODO: Rename and change types and number of parameters
    public static FileBrowser newInstance(String rootDir) {
        FileBrowser fragment = new FileBrowser();
        Bundle args = new Bundle();
        args.putString(ARG_ROOT, rootDir);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRoot = getArguments().getString(ARG_ROOT);
            mCurrentDir = "/";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_file_browser, container, false);
        mFolderView = v.findViewById(R.id.FileFolderList);
        mBreadCrums = v.findViewById(R.id.breadCrums);
        mBreadCrums.setText(mCurrentDir);
        String[] FilesAndFolders = new String[]{"Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(v.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, FilesAndFolders);
        mFolderView.setAdapter(adapter);
        // ListView Item Click Listener
        mFolderView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item value
                String itemValue = (String) mFolderView.getItemAtPosition(position);
            }

        });
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {


    }
}
