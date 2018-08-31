package com.tech.eyeq.capitalloans;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;


import com.tech.eyeq.capitalloans.utils.ViewAnimation;
import static com.tech.eyeq.capitalloans.utils.ViewAnimation.expand;


public class FaqActivity extends AppCompatActivity {

    private View parent_view;

    private NestedScrollView nested_scroll_view;
    private ImageButton btn_toggle_who_is, btn_toggle_how_much,bt_toggle_if_no_pay, bt_toggle_eligible,bt_toggle_approved,
            bt_toggle_how_long, bt_toggle_early_payment,bt_toggle_make_repayments;
    private View lyt_expand_who_is, lyt_expand_how_much, lyt_expand_if_no_pay, lyt_expand_eligible, lyt_expand_approved,
            lyt_expand_how_long,lyt_expand_early_payment,lyt_expand_make_repayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        parent_view = findViewById(android.R.id.content);

        initComponent();
        initToolbar();
    }

    private void initComponent() {

        // text section
        btn_toggle_who_is = findViewById(R.id.bt_toggle_who_is);
        btn_toggle_how_much = findViewById(R.id.bt_toggle_how_much);
        bt_toggle_if_no_pay = findViewById(R.id.bt_toggle_if_no_pay);
        bt_toggle_eligible = findViewById(R.id.bt_toggle_eligible);
        bt_toggle_approved = findViewById(R.id.bt_toggle_approved);
        bt_toggle_how_long = findViewById(R.id.bt_toggle_how_long);
        bt_toggle_early_payment = findViewById(R.id.bt_toggle_early_payment);
        bt_toggle_make_repayments = findViewById(R.id.bt_toggle_make_repayments);


        lyt_expand_who_is = findViewById(R.id.lyt_expand_who_is);
        lyt_expand_how_much = findViewById(R.id.lyt_expand_how_much);
        lyt_expand_if_no_pay= findViewById(R.id.lyt_expand_if_no_pay);
        lyt_expand_eligible= findViewById(R.id.lyt_expand_eligible);
        lyt_expand_approved= findViewById(R.id.lyt_expand_approved);
        lyt_expand_how_long= findViewById(R.id.lyt_expand_how_long);
        lyt_expand_early_payment= findViewById(R.id.lyt_expand_early_payment);
        lyt_expand_make_repayments= findViewById(R.id.lyt_expand_make_repayments);

        lyt_expand_who_is.setVisibility(View.VISIBLE);
        lyt_expand_how_much.setVisibility(View.GONE);
        lyt_expand_if_no_pay.setVisibility(View.GONE);
        lyt_expand_eligible.setVisibility(View.GONE);
        lyt_expand_approved.setVisibility(View.GONE);
        lyt_expand_how_long.setVisibility(View.GONE);
        lyt_expand_early_payment.setVisibility(View.GONE);
        lyt_expand_make_repayments.setVisibility(View.GONE);

        /*BUTTON PRESSES*/
        btn_toggle_who_is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionWhoIs(btn_toggle_who_is);
            }
        });

        btn_toggle_how_much.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionHowMuch(btn_toggle_how_much);
            }
        });

        bt_toggle_if_no_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionIfNoPay(bt_toggle_if_no_pay);
            }
        });

        bt_toggle_eligible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionEligible(bt_toggle_eligible);
            }
        });

        bt_toggle_approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionApproved(bt_toggle_approved);
            }
        });

        bt_toggle_how_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionHowLong(bt_toggle_how_long);
            }
        });

        bt_toggle_early_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionEarlyPayment(bt_toggle_early_payment);
            }
        });

        bt_toggle_make_repayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionMakeRepayments(bt_toggle_make_repayments);
            }
        });

        // Nested Scroll View
        nested_scroll_view = findViewById(R.id.nested_scroll_view);
    }

    private void toggleSectionWhoIs(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_who_is, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    com.tech.eyeq.capitalloans.utils.Tools.nestedScrollTo(nested_scroll_view, lyt_expand_who_is);
                    ViewAnimation.collapse(lyt_expand_how_much);
                    ViewAnimation.collapse(lyt_expand_if_no_pay);
                    ViewAnimation.collapse(lyt_expand_eligible);
                    ViewAnimation.collapse(lyt_expand_approved);
                    ViewAnimation.collapse(lyt_expand_how_long);
                    ViewAnimation.collapse(lyt_expand_early_payment);
                    ViewAnimation.collapse(lyt_expand_make_repayments);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_who_is);
        }
    }

    private void toggleSectionHowMuch(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_how_much, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    com.tech.eyeq.capitalloans.utils.Tools.nestedScrollTo(nested_scroll_view, lyt_expand_how_much);
                    ViewAnimation.collapse(lyt_expand_if_no_pay);
                    ViewAnimation.collapse(lyt_expand_who_is);
                    ViewAnimation.collapse(lyt_expand_eligible);
                    ViewAnimation.collapse(lyt_expand_approved);
                    ViewAnimation.collapse(lyt_expand_how_long);
                    ViewAnimation.collapse(lyt_expand_early_payment);
                    ViewAnimation.collapse(lyt_expand_make_repayments);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_how_much);
        }
    }

    private void toggleSectionIfNoPay(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_if_no_pay, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    com.tech.eyeq.capitalloans.utils.Tools.nestedScrollTo(nested_scroll_view, lyt_expand_if_no_pay);
                    ViewAnimation.collapse(lyt_expand_how_much);
                    ViewAnimation.collapse(lyt_expand_who_is);
                    ViewAnimation.collapse(lyt_expand_eligible);
                    ViewAnimation.collapse(lyt_expand_approved);
                    ViewAnimation.collapse(lyt_expand_how_long);
                    ViewAnimation.collapse(lyt_expand_early_payment);
                    ViewAnimation.collapse(lyt_expand_make_repayments);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_if_no_pay);
        }
    }

    private void toggleSectionEligible(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_eligible, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    com.tech.eyeq.capitalloans.utils.Tools.nestedScrollTo(nested_scroll_view, lyt_expand_eligible);
                    ViewAnimation.collapse(lyt_expand_how_much);
                    ViewAnimation.collapse(lyt_expand_who_is);
                    ViewAnimation.collapse(lyt_expand_if_no_pay);
                    ViewAnimation.collapse(lyt_expand_approved);
                    ViewAnimation.collapse(lyt_expand_how_long);
                    ViewAnimation.collapse(lyt_expand_early_payment);
                    ViewAnimation.collapse(lyt_expand_make_repayments);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_eligible);
        }
    }

    private void toggleSectionApproved(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_approved, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    com.tech.eyeq.capitalloans.utils.Tools.nestedScrollTo(nested_scroll_view, lyt_expand_approved);
                    ViewAnimation.collapse(lyt_expand_how_much);
                    ViewAnimation.collapse(lyt_expand_who_is);
                    ViewAnimation.collapse(lyt_expand_if_no_pay);
                    ViewAnimation.collapse(lyt_expand_eligible);
                    ViewAnimation.collapse(lyt_expand_how_long);
                    ViewAnimation.collapse(lyt_expand_early_payment);
                    ViewAnimation.collapse(lyt_expand_make_repayments);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_approved);
        }
    }


    private void toggleSectionHowLong(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_how_long, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    com.tech.eyeq.capitalloans.utils.Tools.nestedScrollTo(nested_scroll_view, lyt_expand_how_long);
                    ViewAnimation.collapse(lyt_expand_how_much);
                    ViewAnimation.collapse(lyt_expand_who_is);
                    ViewAnimation.collapse(lyt_expand_if_no_pay);
                    ViewAnimation.collapse(lyt_expand_eligible);
                    ViewAnimation.collapse(lyt_expand_approved);
                    ViewAnimation.collapse(lyt_expand_early_payment);
                    ViewAnimation.collapse(lyt_expand_make_repayments);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_how_long);
        }
    }

    private void toggleSectionEarlyPayment(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_early_payment, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    com.tech.eyeq.capitalloans.utils.Tools.nestedScrollTo(nested_scroll_view, lyt_expand_early_payment);
                    ViewAnimation.collapse(lyt_expand_how_much);
                    ViewAnimation.collapse(lyt_expand_who_is);
                    ViewAnimation.collapse(lyt_expand_if_no_pay);
                    ViewAnimation.collapse(lyt_expand_eligible);
                    ViewAnimation.collapse(lyt_expand_approved);
                    ViewAnimation.collapse(lyt_expand_how_long);
                    ViewAnimation.collapse(lyt_expand_make_repayments);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_early_payment);
        }
    }

    private void toggleSectionMakeRepayments(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_make_repayments, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    com.tech.eyeq.capitalloans.utils.Tools.nestedScrollTo(nested_scroll_view, lyt_expand_make_repayments);
                    ViewAnimation.collapse(lyt_expand_how_much);
                    ViewAnimation.collapse(lyt_expand_who_is);
                    ViewAnimation.collapse(lyt_expand_if_no_pay);
                    ViewAnimation.collapse(lyt_expand_eligible);
                    ViewAnimation.collapse(lyt_expand_approved);
                    ViewAnimation.collapse(lyt_expand_how_long);
                    ViewAnimation.collapse(lyt_expand_early_payment);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_make_repayments);
        }
    }


    public boolean toggleArrow(View view) {

        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }

    }

    //set toolbar method
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_button_light);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("FAQs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // actionBar back button code
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
