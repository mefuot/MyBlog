package com.pong.myblog.fragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.pong.myblog.R;
import com.pong.myblog.contract.BlogEditContract;
import com.pong.myblog.listener.OnBlogEditFragmentListener;
import com.pong.myblog.model.BlogModel;
import com.pong.myblog.presenter.BlogEditPresenter;

import java.util.Calendar;

import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by USER on 10/1/2560.
 */

public class BlogEditFragment extends Fragment implements BlogEditContract.BlogEditView {
    private BlogEditPresenter presenter;
    private RichEditor editor;
    private EditText textTitle;
    private EditText textDate;
    private int blogId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        blogId = getArguments().getInt("blogId", -1);
        return inflater.inflate(R.layout.fragment_blog_edit, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textTitle = (EditText) view.findViewById(R.id.edittext_title);
        textDate = (EditText) view.findViewById(R.id.edittext_date);
        editor = (RichEditor) view.findViewById(R.id.editor);
        setupDateFunction();
        setupContentEditor(view);

        presenter = new BlogEditPresenter(getActivity(), this);
        if (blogId > 0) {
            presenter.loadBlogData(blogId);
        }

        view.findViewById(R.id.button_add_new_blog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveButtonClicked();
            }
        });
    }

    private void setupDateFunction() {
        final Calendar calendar = Calendar.getInstance();
        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        textDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePicker.show();
            }
        });
    }

    private void setupContentEditor(@NonNull View view) {
        editor.setEditorHeight(200);
        editor.setEditorFontSize(18);
        editor.setEditorFontColor(Color.BLACK);
        editor.setPadding(10, 10, 10, 10);

        editor.setPlaceholder("Insert text here...");

        view.findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setBold();
            }
        });

        view.findViewById(R.id.action_italic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setItalic();
            }
        });

        view.findViewById(R.id.action_subscript).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setSubscript();
            }
        });

        view.findViewById(R.id.action_superscript).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setSuperscript();
            }
        });

        view.findViewById(R.id.action_strikethrough).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setStrikeThrough();
            }
        });

        view.findViewById(R.id.action_underline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setUnderline();
            }
        });

        view.findViewById(R.id.action_heading1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setHeading(1);
            }
        });

        view.findViewById(R.id.action_heading2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setHeading(2);
            }
        });

        view.findViewById(R.id.action_heading3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setHeading(3);
            }
        });

        view.findViewById(R.id.action_heading4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setHeading(4);
            }
        });

        view.findViewById(R.id.action_heading5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setHeading(5);
            }
        });

        view.findViewById(R.id.action_heading6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setHeading(6);
            }
        });

        view.findViewById(R.id.action_indent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setIndent();
            }
        });

        view.findViewById(R.id.action_outdent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setOutdent();
            }
        });

        view.findViewById(R.id.action_align_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setAlignLeft();
            }
        });

        view.findViewById(R.id.action_align_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setAlignCenter();
            }
        });

        view.findViewById(R.id.action_align_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setAlignRight();
            }
        });

        view.findViewById(R.id.action_blockquote).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setBlockquote();
            }
        });

        view.findViewById(R.id.action_insert_bullets).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setBullets();
            }
        });

        view.findViewById(R.id.action_insert_numbers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setNumbers();
            }
        });

        view.findViewById(R.id.action_insert_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.insertImage("http://www.1honeywan.com/dachshund/image/7.21/7.21_3_thumb.JPG",
                        "dachshund");
            }
        });

        view.findViewById(R.id.action_insert_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputLinkDialog();
            }
        });
    }

    private void showInputLinkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add link");

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View enterLinkView = inflater.inflate(R.layout.dialog_add_link, null);
        final EditText mUrl = (EditText) enterLinkView.findViewById(R.id.edittext_link_url);
        final EditText mLabel = (EditText) enterLinkView.findViewById(R.id.edittext_link_label);
        builder.setView(enterLinkView);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (mUrl.getText().toString().isEmpty()) return;
                if (mLabel.getText().toString().isEmpty()) {
                    mLabel.setText(mUrl.getText().toString());
                }
                editor.insertLink(mUrl.getText().toString(), mLabel.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


    @Override
    public void onExistBlogDataLoaded(BlogModel blog) {
        textTitle.setText(blog.getTitle());
        textDate.setText(blog.getDate());
        editor.setHtml(blog.getContent());
    }

    @Override
    public void onNewBlogAdded() {
        ((OnBlogEditFragmentListener) getActivity()).onBlogEdited();
    }

    @Override
    public void onModifiedBlogData() {
        ((OnBlogEditFragmentListener) getActivity()).onBlogEdited();
    }

    private void onSaveButtonClicked() {
        BlogModel blog = new BlogModel();
        blog.setTitle(textTitle.getText().toString());
        blog.setDate(textDate.getText().toString());
        blog.setContent(editor.getHtml());

        if (blogId > 0) {
            presenter.editExistBlogData(blogId, blog);
        } else {
            presenter.insertNewBlog(blog);
        }
    }

    @Override
    public void onDestroy() {
        presenter.closeDb();
        super.onDestroy();
    }
}
