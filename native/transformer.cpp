#include <jni.h>
#include "ua_khpi_oop_lab16_NativeTransformer.h" // Згенерований header-файл

JNIEXPORT jdoubleArray JNICALL Java_ua_khpi_oop_lab16_NativeTransformer_transformNative
  (JNIEnv *env, jobject obj, jdoubleArray array, jdouble a, jdouble b) {
    
    // Перевірка на null, щоб уникнути падіння програми (Segmentation Fault)
    if (array == nullptr) {
        return nullptr;
    }

    // Отримуємо довжину масиву та вказівник на його елементи з пам'яті Java
    jsize len = env->GetArrayLength(array);
    jdouble *body = env->GetDoubleArrayElements(array, 0);

    // Створюємо новий масив у JVM для збереження результату
    jdoubleArray result = env->NewDoubleArray(len);
    if (result == nullptr) {
        // Якщо немає пам'яті, звільняємо ресурси і повертаємо null
        env->ReleaseDoubleArrayElements(array, body, JNI_ABORT);
        return nullptr; 
    }
    jdouble *resultBody = env->GetDoubleArrayElements(result, 0);

    // Виконуємо лінійне перетворення (варіант 15)
    for (int i = 0; i < len; i++) {
        resultBody[i] = a * body[i] + b;
    }

    // Повертаємо новий масив у Java (0 - означає зберегти зміни)
    env->ReleaseDoubleArrayElements(result, resultBody, 0);
    // Звільняємо оригінальний масив (JNI_ABORT - не копіювати зміни назад, бо ми лише читали)
    env->ReleaseDoubleArrayElements(array, body, JNI_ABORT);

    return result;
}