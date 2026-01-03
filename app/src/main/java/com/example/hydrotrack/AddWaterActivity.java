PrefManager pref = new PrefManager(this);

int intake = Integer.parseInt(etWater.getText().toString());
int total = pref.getWater() + intake;
pref.setWater(total);

Toast.makeText(this, "Water Added 💧", Toast.LENGTH_SHORT).show();
