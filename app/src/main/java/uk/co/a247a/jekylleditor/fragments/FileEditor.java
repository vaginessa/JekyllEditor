package uk.co.a247a.jekylleditor.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.a247a.jekylleditor.R;
import uk.co.a247a.jekylleditor.interfaces.FileEditorInterface;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FileEditor.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FileEditor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FileEditor extends Fragment implements FileEditorInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_FILE = "file";

    // TODO: Rename and change types of parameters
    private String mFileName;

    private OnFragmentInteractionListener mListener;

    public FileEditor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param file Parameter 1.
     * @return A new instance of fragment FileEditor.
     */
    // TODO: Rename and change types and number of parameters
    public static FileEditor newInstance(String file) {
        FileEditor fragment = new FileEditor();
        Bundle args = new Bundle();
        args.putString(ARG_FILE, file);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFileName = getArguments().getString(ARG_FILE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_file_editor, container, false);
        return v;
    }

    private void save() {
        //If saved successfull notify the activity that the file saved
        if (false) {
            mListener.onFileSaveStateChange(true);
        }
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

    @Override
    public void changeFile(String file) {
        mFileName = file;
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
        // TODO: Update argument type and name
        void onFileSaveStateChange(boolean fileSaved);
    }


}
