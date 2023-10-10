//
// Created by lexin on 2023/10/10.
//
#include "util.h"

struct param {
    int f1;
    int f2;
};

struct response {
    int res;
    int res2;
};

extern "C" {
response *calculate(struct param *p) {
    struct response *res = (struct response *) malloc(sizeof(struct response));
    if (p != NULL) {
        res->res = p->f1 + p->f2;
    }
    return res;
}
}

