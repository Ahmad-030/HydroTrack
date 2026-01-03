int water = pref.getWater();
int target = pref.getTarget();

int progress = (water * 100) / target;
progressBar.setProgress(progress);
