package com.example.karim.cleaneradmin.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.karim.cleaneradmin.Model.Bus;
import com.example.karim.cleaneradmin.Model.Clean;
import com.example.karim.cleaneradmin.Model.Cost;
import com.example.karim.cleaneradmin.Model.Family;
import com.example.karim.cleaneradmin.Model.GlassSwitch;
import com.example.karim.cleaneradmin.Model.Other;
import com.example.karim.cleaneradmin.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class EditActivity extends AppCompatActivity {


    private void GetDesign(){
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("Other"))
                    FirebaseDatabase.getInstance().getReference().child("Other").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String check=((Map)dataSnapshot.getValue()).get("Type").toString();
                            if(check.equals("0"))
                                otherControl.setChecked(false);
                            else
                                otherControl.setChecked(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("Cost"))
                    FirebaseDatabase.getInstance().getReference().child("Cost").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String check=((Map)dataSnapshot.getValue()).get("Type").toString();
                            if(check.equals("0"))
                                costControl.setChecked(false);
                            else
                                costControl.setChecked(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("Family"))
                    FirebaseDatabase.getInstance().getReference().child("Family").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String check=((Map)dataSnapshot.getValue()).get("Type").toString();
                            if(check.equals("0"))
                                familyControl.setChecked(false);
                            else
                                familyControl.setChecked(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("Bus"))
                    FirebaseDatabase.getInstance().getReference().child("Bus").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String check=((Map)dataSnapshot.getValue()).get("Type").toString();
                            if(check.equals("0"))
                                busControl.setChecked(false);
                            else
                                busControl.setChecked(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("Clean"))
                    FirebaseDatabase.getInstance().getReference().child("Clean").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String check=((Map)dataSnapshot.getValue()).get("Type").toString();
                            if(check.equals("0"))
                                cleanControl.setChecked(false);
                            else
                                cleanControl.setChecked(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("Glass"))
                    FirebaseDatabase.getInstance().getReference().child("Glass").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String check=((Map)dataSnapshot.getValue()).get("Type").toString();
                            if(check.equals("0"))
                                glassControl.setChecked(false);
                            else
                                glassControl.setChecked(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    Switch glassControl,cleanControl,busControl,familyControl,costControl,otherControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        otherControl=findViewById(R.id.otherControl);
        otherControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Other other=new Other();
                if(b)
                    other.SetType("1");
                else
                    other.SetType("0");
                FirebaseDatabase.getInstance().getReference().child("Other").setValue(other).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditActivity.this, "تم", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        costControl=findViewById(R.id.costControl);
        costControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Cost cost=new Cost();
                if(b)
                    cost.SetType("1");
                else
                    cost.SetType("0");
                FirebaseDatabase.getInstance().getReference().child("Cost").setValue(cost).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditActivity.this, "تم", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        familyControl=findViewById(R.id.familyControl);
        familyControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Family family=new Family();
                if(b)
                    family.SetType("1");
                else
                    family.SetType("0");
                FirebaseDatabase.getInstance().getReference().child("Family").setValue(family).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditActivity.this, "تم", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        busControl=findViewById(R.id.busControl);
        busControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Bus bus=new Bus();
                if(b)
                    bus.SetType("1");
                else
                    bus.SetType("0");
                FirebaseDatabase.getInstance().getReference().child("Bus").setValue(bus).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditActivity.this, "تم", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        cleanControl=findViewById(R.id.cleanControl);
        cleanControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Clean clean=new Clean();
                if(b)
                    clean.SetType("1");
                else
                    clean.SetType("0");
                FirebaseDatabase.getInstance().getReference().child("Clean").setValue(clean).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditActivity.this, "تم", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        glassControl=findViewById(R.id.glassControl);
        glassControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                GlassSwitch glassSwitch=new GlassSwitch();
                if(b)
                    glassSwitch.SetType("1");
                else
                    glassSwitch.SetType("0");
                FirebaseDatabase.getInstance().getReference().child("Glass").setValue(glassSwitch).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditActivity.this, "تم", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        GetDesign();
    }
}
