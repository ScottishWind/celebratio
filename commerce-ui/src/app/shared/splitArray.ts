import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'splitArray'
})

export class SplitArray {
  transform(array: any, size): Object[] {
    var results = [];
    if (array !== undefined) {
      while (array.length) {
        results.push(array.splice(0, size));
      }
      return results;
    }
  }
}

