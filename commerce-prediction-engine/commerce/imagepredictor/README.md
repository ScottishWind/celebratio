****************
README
****************

CLASSIFIERS:
durga
ganesh
shiva
krishna
hanuman


MODEL ACCURACCY :
Final test accuracy = 81.8% (N=22)

To Predict:
    python imageClassification.py "<image to predict>"


To Train the model run (Already done):

    python retrain.py
    \
    --bottleneck_dir=bottlenecks
    \
    --how_many_training_steps=500
    \
    --model_dir=inception
    \
    --summaries_dir=training_summaries/basic
    \
    --output_graph=retrained_graph.pb
    \
    --output_labels=retrained_labels.txt
    \
    --image_dir=datasets/idols



